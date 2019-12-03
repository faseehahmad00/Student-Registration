//Class to control Stages
package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class menucontrol extends Application {
    Stage stagereg = new Stage();
    Stage stagemenu = new Stage();
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage.setTitle("WELCOME TO STUDENT REGISTRATION");
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
    }
    public void end(Stage stage){
        stage.hide();
    }

}