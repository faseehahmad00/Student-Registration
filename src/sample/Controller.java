package sample;
import com.jfoenix.controls.JFXDatePicker;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;


public class Controller {
    @FXML
    private PasswordField passwordField = new PasswordField();
    @FXML
    private TextField textField = new TextField();
    @FXML
    private TextField name = new TextField();
    @FXML
    private TextField fname = new TextField();
    @FXML
    private TextField email = new TextField();
    @FXML
    private TextField phone = new TextField();
    @FXML
    private TextField address = new TextField();
    @FXML
    private TextField cnic = new TextField();
    @FXML
    private Text errormsg = new Text();
    @FXML
    private Label emptyfield = new Label();
    @FXML
    private RadioButton male = new RadioButton();
    @FXML
    private RadioButton female = new RadioButton();
    @FXML
    JFXDatePicker datePicker = new JFXDatePicker();
    @FXML
    private RadioButton bsse = new RadioButton();
    @FXML
    private RadioButton bscs = new RadioButton();
    @FXML
    private Label regsuccess = new Label();
    @FXML
    private TextField removeid = new TextField();
    @FXML
    private Label removemsg = new Label();
    String gender;
    String degree;
    DataBase database = new DataBase();

    //buttons,textfields etc
    //LOGIN FORM START======================================================================================================
    public void onexitclick() {
        Platform.exit();
    }

    public void onclick() {
        String passcode = "";
        String username = "";
        if (passcode.equals(passwordField.getText()) && username.equals(textField.getText())) {
            System.out.println("login successful");
            errormsg.setText("login Successful");

            try {
                Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                Main.primaryStage.setScene(new Scene(root));
                Main.primaryStage.setFullScreen(true);
            } catch (Exception ignored) {
            }
        } else if (textField.getText().isEmpty()) {
            textField.setPromptText("Enter username");
        } else if (passwordField.getText().isEmpty()) {
            passwordField.setPromptText("Enter password");
        } else {
            System.out.println("Invalid username or password");
            errormsg.setText(">>> invalid username or password");
        }
    }

    public void openabout(){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setFullScreen(true);
        } catch (Exception ignored) {
        }
    }

    public void onaboutcancel() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setFullScreen(true);
        } catch (Exception ignored) {}
    }
//LOGIN FORM END========================================================================================================


    ///MENU BAR START=======================================================================================================
    public void add() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("regform.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setFullScreen(true);
        } catch (Exception ignored) {
        }

    }

    public void delete() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setFullScreen(true);
        } catch (Exception ignored) {
        }

    }

    public void logout() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setFullScreen(true);
        } catch (Exception ignored) {
        }

    }
//MENU BAR END==========================================================================================================


    //REGISTRATION FORM START===============================================================================================
    public void oncancel() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setFullScreen(true);
        } catch (Exception ignored) {
        }
    }

    public void onsaveclicked() throws SQLException {//on pressing save button on registration form.
        if (male.isSelected()) {
            gender = "male";}
        if (female.isSelected()) {
            gender = "female"; }
        if (bscs.isSelected()) {
            degree = "BSCS"; }
        if (bsse.isSelected()) {
            degree = "BSSE"; }
        //  radio button functions
       // String  date = datePicker.getValue().toString();
        if (fname.getText().isEmpty() || phone.getText().isEmpty() || datePicker.getValue().toString().isEmpty()
                || cnic.getText().isEmpty() || email.getText().isEmpty() || address.getText().isEmpty()
                 || degree.isEmpty() || gender.isEmpty() || fname.getText().isEmpty()
        ) {

            emptyfield.setText("please fill all reqiured fields to continue");


        } else {
            if (cnic.getText().length() != 13)
            {emptyfield.setText("enter your cnic correctly without -.it must contain only 13 letters");}

            else{
            database.insert(name.getText(),fname.getText(),address.getText(),phone.getText()
                        ,gender,degree,email.getText(),cnic.getText(),datePicker.getValue().toString());

            try {
                Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                Main.primaryStage.setScene(new Scene(root));
                Main.primaryStage.setFullScreen(true);
                regsuccess.setText("Student added successfully");

            } catch (Exception ignored) {
            }
        }}
    }

//REGISTRATION FORM END=================================================================================================
 //
//REMOVE FXML START====================================================================================================
    public void studentremove() throws SQLException {
        if(removeid.getText().isEmpty() || removemsg.getText().length() != 13 )
        {
            removemsg.setText("This cnic doesn't exist.Please enter valid student cnic");
        }
        else {
            database.delete(removeid.getText());
            try {
                Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                Main.primaryStage.setScene(new Scene(root));
                Main.primaryStage.setFullScreen(true);
            } catch (Exception ignored) {
            }
        }}


}
