package sample;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.IOException;


public class Controller {
    @FXML
    PasswordField passwordField = new PasswordField();
    @FXML
    TextField textField = new TextField();
    @FXML
    Label label = new Label();
    @FXML
    TextField name = new TextField();
    @FXML
    TextField fname = new TextField();
    @FXML
    TextField email = new TextField();
    @FXML
    TextField phone = new TextField();
    @FXML
    TextField address = new TextField();
    @FXML
    TextField gender = new TextField();
    @FXML
    TextField dob = new TextField();
    @FXML
    TextField degree = new TextField();
    @FXML
    TextField cnic = new TextField();
    @FXML
    Text errormsg = new Text();
    @FXML
    Stage stagemenu = new Stage();
    @FXML
    Stage stagereg = new Stage();

//LOGIN FORM START======================================================================================================
        public void onexitclick () {
            Platform.exit();
        }

        public void onclick () throws Exception {
            String passcode = "admin";
            String username = "admin";
            if (passcode.equals(passwordField.getText()) && username.equals(textField.getText())) {
                Parent root1 = FXMLLoader.load(getClass().getResource("menu.fxml"));
                System.out.println("login successful");
                //opening Registration form using login form
                stagemenu.setTitle("WELCOME TO STUDENT REGISTRATION");
                stagemenu.setScene(new Scene(root1));
                stagemenu.initStyle(StageStyle.UNDECORATED);
                stagemenu.show();

                stagemenu.setFullScreen(true);

            } else if (textField.getText().isEmpty()) {
                textField.setPromptText("Enter username");
            } else if (passwordField.getText().isEmpty()) {
                passwordField.setPromptText("Enter password");
            } else {
                System.out.println("Invalid username or password");
                errormsg.setText(">>> invalid username or password");
            }


        }
//LOGIN FORM END========================================================================================================

///MENU BAR START=======================================================================================================
        public void add () throws IOException {
            //opening Registration form using login form
            stagemenu.close();
            Parent root = FXMLLoader.load(getClass().getResource("regform.fxml"));
            stagereg.setTitle("WELCOME TO STUDENT REGISTRATION");
            stagereg.setScene(new Scene(root));
            stagereg.initStyle(StageStyle.UNDECORATED);
            stagereg.show();
            stagereg.setFullScreen(true);

            label.setText("1");
        }
//MENU BAR END==========================================================================================================

//REGISTRATION FORM START===============================================================================================
        public void oncancel () throws IOException {
            stagereg.close();
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            stagemenu.setTitle("WELCOME TO STUDENT REGISTRATION");
            stagemenu.setScene(new Scene(root));
            stagereg.initStyle(StageStyle.UNDECORATED);
            stagemenu.show();
            stagemenu.setFullScreen(true);

        }

        public void onsaveclicked () { //on pressing save button on registration form.
            System.out.println(label.getText());
            System.out.println(name.getText());
            System.out.println(fname.getText());
            System.out.println(gender.getText());
            System.out.println(cnic.getText());
            System.out.println(dob.getText());
            System.out.println(phone.getText());
            System.out.println(address.getText());
            System.out.println(degree.getText());
            System.out.println(email.getText());
        }
//REGISTRATION FORM END=================================================================================================

    }
