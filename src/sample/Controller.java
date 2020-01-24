package sample;
import com.jfoenix.controls.JFXDatePicker;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    String gender;
    String degree;
    DataBase database = new DataBase();
    @FXML
    private AnchorPane anchorpane;
    @FXML
    JFXDatePicker datePicker;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username,name,fathername,email,phone,address,cnic,removeid,display_cnic;
    @FXML
    private Label signup_error,registration_error,display_error,remove_error,menu_error;
    @FXML
    private RadioButton male,female,bsse,bscs;
    @FXML
    private Label labelname,labelfname,labelgender,labeldegree,labelphone,labelmail,labeladdress,labelcnic,labelDOB;

//LOGIN FORM START======================================================================================================
    public void onexitclick() {
        Platform.exit();
        database.closeDB();
    }

    public void onclick() {
        String passcode = "admin";
        String username = "admin";
        if (passcode.equals(password.getText()) && username.equals(this.username.getText())) {
            System.out.println("login successful");
            signup_error.setText("login Successful");
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Menuform.fxml"));
                Main.primaryStage.setScene(new Scene(root));
                Main.primaryStage.setFullScreen(true);
            } catch (Exception ignored) {
            }

        } else if (this.username.getText().isEmpty()) {
            this.username.setPromptText("Enter username");
        } else if (password.getText().isEmpty()) {
            password.setPromptText("Enter password");
        } else {
            System.out.println("Invalid username or password");
            signup_error.setText(">>> invalid username or password");
        }
    }

    public void openabout() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setFullScreen(true);
        } catch (Exception ignored) {
        }
    }

    public void onaboutcancel() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Signin.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setFullScreen(true);
        } catch (Exception ignored) {
        }
    }
//LOGIN FORM END========================================================================================================


//MENU BAR START========================================================================================================
    public void addstudent() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Registrationform.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setFullScreen(true);
        } catch (Exception ignored) {
        }
    }

    public void deletestudent() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setFullScreen(true);
        } catch (Exception ignored) {
        }
    }

    public void displaystudent() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Display.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setFullScreen(true);
        } catch (Exception ignored) {
        }
    }

    public void logout() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Signin.fxml"));
            Main.primaryStage.setScene(new Scene(root));
            Main.primaryStage.setFullScreen(true);
            database.closeDB();
        } catch (Exception ignored) {
        }
    }
//MENU BAR END==========================================================================================================

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
        if (male.isSelected())  {gender = "male"; }
        if (female.isSelected()) { gender = "female"; }
        if (bscs.isSelected()) { degree = "BSCS"; }
        if (bsse.isSelected()) { degree = "BSSE"; }
        

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

//REMOVE FXML START=====================================================================================================
    public void removestudent() {
        boolean condition = (removeid
                .getText().length() == 13);
        if (condition) {
            database.delete(removeid.getText());
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Menuform.fxml"));
                Main.primaryStage.setScene(new Scene(root));
                Main.primaryStage.setFullScreen(true);
            } catch (Exception ignored) {
            }
        } else {
            remove_error.setText("This cnic doesn't exist.Please enter valid student cnic");

        }
    }

//REMOVE FXML END=======================================================================================================
//Display FXML START====================================================================================================
    public void displaydetails() {
        if (display_cnic.getText().length() == 13) {
            ArrayList<String> student = null;
            try {
                student = database.display(display_cnic.getText());
            } catch (Exception e) {
                System.out.println("unable to display");
            }
            assert student != null;
            if (student.size() > 0) {
                anchorpane.setVisible(true);
                display_error.setText("(record found)");
                labelname.setText("Name:" + "\t\t\t\t\t" + student.get(0));
                labelfname.setText("Father Name:" + "\t\t\t\t" + student.get(1));
                labelphone.setText("Phone:" + "\t\t\t\t\t" + student.get(2));
                labeladdress.setText("Address:" + "\t\t\t\t\t" + student.get(3));
                labeldegree.setText("Degree:" + "\t\t\t\t\t" + student.get(4));
                labelgender.setText("Gender:" + "\t\t\t\t\t" + student.get(5));
                labelmail.setText("Email:" + "\t\t\t\t\t" + student.get(6));
                labelcnic.setText("CNIC:" + "\t\t\t\t\t" + student.get(7));
                labelDOB.setText("DOB:" + "\t\t\t\t\t" + student.get(8));
            }
            else {
                display_error.setText("Student not found.Enter registered cnic");
                  anchorpane.setVisible(false);
            }
        } else {
            display_error.setText("enter valid cnic");
           anchorpane.setVisible(false);
        }
    }


// Display FXML END====================================================================================================
}
