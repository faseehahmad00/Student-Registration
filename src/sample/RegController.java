package sample;

import com.jfoenix.controls.JFXDatePicker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegController implements Initializable {
    String gender;
    String degree;

    @FXML
    JFXDatePicker datePicker;
    @FXML
    private TextField name, fathername, email, phone, address, cnic;
    @FXML
    private Label registration_error;
    @FXML
    private ComboBox<String> gendercombo;
    @FXML
    private ComboBox<String> degreecombo;

    DataBase database = new DataBase();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        degreecombo.getItems().setAll("BSCS", "BSSE");
        gendercombo.getItems().setAll("male", "female");
    }

    //REGISTRATION FORM START===============================================================================================
    public void oncancel() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Menuform.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setFullScreen(true);
        } catch (Exception ignored) {
        }
    }

    public void enrollstudent() {//on pressing save button on registration form.
        //radio button functions...........
        gender = gendercombo.getValue();
        degree = degreecombo.getValue();

        if (fathername.getText().isEmpty() || phone.getText().isEmpty() || datePicker.getValue().toString().isEmpty()
                || cnic.getText().isEmpty() || email.getText().isEmpty() || address.getText().isEmpty()
                || degree.isEmpty() || gender.isEmpty() || fathername.getText().isEmpty()) {
            registration_error.setText("please fill all reqiured fields to continue");
        } else {
            if (cnic.getText().length() != 13) {
                registration_error.setText("enter your cnic correctly without - .It must contain only 13 letters");
            } else {
                database.insert(name.getText(), fathername.getText(), address.getText(), phone.getText()
                        , gender, degree, email.getText(), cnic.getText(), datePicker.getValue().toString());
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("Menuform.fxml"));
                    Main.primaryStage.setScene(new Scene(root));
                    Main.primaryStage.setFullScreen(true);
                } catch (IOException ignored) {

                }
            }
        }
    }

//REGISTRATION FORM END=================================================================================================

}
