package sample.Controller;

import javafx.event.Event;
import javafx.fxml.FXML.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.App.ActivStage;
import sample.App.Main;
import sample.App.Server;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Controller {

    public Button server;
    public Button client;


    public void ActivServ(MouseEvent mouseEvent) throws IOException {
        server.setText("ВЫБРАНО");

        Main.getActivStage().nextStage("..//Style//StyleServer.fxml");

        server.setText("Сервер");
    }


    public void ActivClient(MouseEvent mouseEvent) throws IOException {
        client.setText("ВЫБРАНО");
        Main.getActivStage().nextStage("..//Style//StyleClient.fxml");

        client.setText("Клиент");
    }
}
