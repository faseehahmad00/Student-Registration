package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class About implements Initializable {
    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition tt = new TranslateTransition(Duration.seconds(4), label);
        tt.setToX(label.getLayoutX());
        tt.play();
    }
}
