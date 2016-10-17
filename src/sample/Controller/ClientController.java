package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sample.App.Client;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by Alastor on 01.10.2016.
 */
public class ClientController {
    private String Name = "Name";
    private ObservableList<String> massages;
    private ArrayList<String> buffmassage = new ArrayList<>();
    public Button addName;
    public TextField placeName;
    public ListView<String> oldMasseges;
    public TextField addMassage;
    private Client client;
    public Button addIP;
    public TextField placeServerIP;


    public void addLine(String line){
        buffmassage.add(line);
        massages = FXCollections.observableArrayList(buffmassage);
        oldMasseges.setItems(massages);
        addMassage.setText("");
    }


    public void addServerIP(MouseEvent mouseEvent) {

        try {
            client = new Client(placeServerIP.getText(),this);


        } catch (UnknownHostException e) {
            System.out.println("Ошибка клиента: "+e);
        }
    }

    public void setName(MouseEvent mouseEvent) {
        Name = placeName.getText();
        System.out.println(placeName.getText());
    }

    public void InputMassage(KeyEvent keyEvent) throws UnknownHostException {

        if(keyEvent.getCode() == KeyCode.ENTER)
        {
            if(addMassage.getText() != "")
            {
                buffmassage.add(Name + ": "+ addMassage.getText());
                client.sendMassage(Name + ": "+ addMassage.getText());
                massages = FXCollections.observableArrayList(buffmassage);
                oldMasseges.setItems(massages);
                addMassage.setText("");
            }
        }

    }
}
