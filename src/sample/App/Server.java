package sample.App;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.Controller.ClientController;
import sample.Controller.ServerController;

import java.io.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Alastor on 01.10.2016.
 */
public class Server implements Runnable {
    private boolean control = true;
    private Thread t;
     private ServerSocket server;
    private Socket connection;
    private String line = "";
    private  ObjectOutputStream output;
    private  ObjectInputStream input;
    private DataInputStream in ;
    private DataOutputStream out;
    private ServerController sc;

    public Server(ServerController x){
        sc = x;
        t = new Thread(this,"СерверПоток");
        System.out.println("Серверный поток запущен!");
        t.start();
    }

    @Override
    public void run() {
        try {
            System.out.println("Тут");
            server = new ServerSocket(5678,10);
            while (control)
            {

                connection = server.accept();

                output = new ObjectOutputStream(connection.getOutputStream());

                input = new ObjectInputStream(connection.getInputStream());

                in = new DataInputStream(input);
                out = new DataOutputStream(output);

                line = in.readUTF();

                if(line != "")
                    sc.addLine(line);

            }
        } catch (IOException e) {
            System.out.print("Проблема IP server : " + e);
        }
    }

    public String getLine(){
        return line;
    }

    public void sendMassage(String str)
    {
        try
        {
            out.writeUTF(str);
            out.flush();
        }
        catch (IOException e) {
            System.out.println("Ошибюка отправки: " + e);
        }
    }
    public void stop(){
        control = false;
    }
}
