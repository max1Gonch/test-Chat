package sample.App;

import java.io.IOException;
import java.lang.Exception;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller.Controller;

final public class Main extends Application {
    private static ActivStage primary;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primary = new ActivStage(primaryStage);
    }
   final static public ActivStage getActivStage()
    {
        return primary;
    }



    public static void main(String[] args)
    {
        launch(args);
    }
}
