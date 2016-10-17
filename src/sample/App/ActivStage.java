package sample.App;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Alastor on 02.10.2016.
 */

public class ActivStage {
    private Stage active;
    private String fxml;
    private Parent root;


    public ActivStage(Stage Nactive) throws IOException {
        fxml = "..//Style//sample.fxml";
        this.active = Nactive;
        //Загрузили ресурс файла
        root = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(root);
        active.setScene(scene);
        active.show();
    }
    public void nextStage(String URL) throws IOException {
        fxml = URL;
        root = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(root);
        active.setScene(scene);
        active.show();
    }
    public Stage getStage(){
        return active;
    }
}