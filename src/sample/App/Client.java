package sample.App;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller.ClientController;
import sun.misc.MessageUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by Alastor on 01.10.2016.
 */
public class Client implements Runnable{
    private ClientController cc;
    private Thread t;
    private static Socket connection;
    private String line = "";
    private InetAddress serverAddres;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private DataInputStream in ;
    private DataOutputStream out;

    public Client(String address, ClientController x) throws UnknownHostException {
        ///serverAddres.getByName(address);
        cc = x;
        t = new Thread(this,"КлиентПоток");
        System.out.println("Клиентский поток запущен");
        t.start();
    }

    @Override
    public void run()
    {
        try {
            while (true)
            {
                connection = new Socket("127.0.0.1",5678);
                output = new ObjectOutputStream(connection.getOutputStream());
                input = new ObjectInputStream(connection.getInputStream());

                in = new DataInputStream(input);
                out = new DataOutputStream(output);

                line = in.readUTF();
                if(line != "")
                    cc.addLine(line);

            }
        } catch (IOException e) {
            System.out.print("Проблема IP client : " + e);
        }
    }
    public void sendMassage(String str)
    {
        try
        {
            out.writeUTF(str);
            out.flush();
            // заставляем поток закончить передачу данных.

        }
        catch (IOException e) {
            System.out.println("Ошибка отправки: " + e);
        }
    }


}
