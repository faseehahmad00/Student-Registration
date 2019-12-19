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
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller
        //implements Initializable
{
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
    //    @FXML
//    private Label label1;
    @FXML
    private Label labelname;
    @FXML
    private Label labelfname;
    @FXML
    private Label labelgender;
    @FXML
    private Label labeldegree;
    @FXML
    private Label labelphone;
    @FXML
    private Label labelmail;
    @FXML
    private Label labeladdress;
    @FXML
    private Label labelcnic;
    @FXML
    private Label labelDOB;
    @FXML
    private Label detailslabel;
    @FXML
    private TextField detailsid;
    @FXML
    private AnchorPane anchorPane = new AnchorPane() {{
        setVisible(false);
    }};
    String gender;
    String degree;                                          //fx components definition.

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        TranslateTransition tt = new TranslateTransition();
//        tt.setDuration(Duration.seconds(3));
//        tt.setNode(label1);
//        tt.setToX(70);
//        tt.play();
//    }

    DataBase database = new DataBase();      //Object of Database class ...

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
                Parent root = FXMLLoader.load(getClass().getResource("Menuform.fxml"));
                Main.primaryStage.setScene(new Scene(root));
                Main.primaryStage.setFullScreen(true);
            } catch (Exception ignored) {
            }
            ;

        } else if (textField.getText().isEmpty()) {
            textField.setPromptText("Enter username");
        } else if (passwordField.getText().isEmpty()) {
            passwordField.setPromptText("Enter password");
        } else {
            System.out.println("Invalid username or password");
            errormsg.setText(">>> invalid username or password");
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


    ///MENU BAR START=======================================================================================================
    public void add() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Registrationform.fxml"));
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

    public void ondisplay() {
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

    public void onsaveclicked() {//on pressing save button on registration form.
        if (male.isSelected()) {
            gender = "male";
        }
        if (female.isSelected()) {
            gender = "female";
        }
        if (bscs.isSelected()) {
            degree = "BSCS";
        }
        if (bsse.isSelected()) {
            degree = "BSSE";
        }
        //  ^^^ radio button functions...........
        if (fname.getText().isEmpty() || phone.getText().isEmpty() || datePicker.getValue().toString().isEmpty()
                || cnic.getText().isEmpty() || email.getText().isEmpty() || address.getText().isEmpty()
                || degree.isEmpty() || gender.isEmpty() || fname.getText().isEmpty()) {
            emptyfield.setText("please fill all reqiured fields to continue");
        } else {
            if (cnic.getText().length() != 13) {
                emptyfield.setText("enter your cnic correctly without -.it must contain only 13 letters");
            } else {
                try {
                    database.insert(name.getText(), fname.getText(), address.getText(), phone.getText()
                            , gender, degree, email.getText(), cnic.getText(), datePicker.getValue().toString());
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    Parent root = FXMLLoader.load(getClass().getResource("Menuform.fxml"));
                    Main.primaryStage.setScene(new Scene(root));
                    Main.primaryStage.setFullScreen(true);
                    regsuccess.setText("Student added successfully");

                } catch (Exception ignored) {
                }
            }
        }
    }

    //REGISTRATION FORM END=================================================================================================
    //
//REMOVE FXML START====================================================================================================
    public void studentremove() {
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
            removemsg.setText("This cnic doesn't exist.Please enter valid student cnic");
        }
    }

    //REMOVE FXML END=======================================================================================================
//Display FXML START====================================================================================================
    public void getdetails() {
        if (!(detailsid.getText().isEmpty())) {
            ArrayList<String> student = null;
            try {
                student = database.display(detailsid.getText());
            } catch (Exception e) {
                System.out.println("unable to display");
            }
            if (student.size() > 0) {
                anchorPane.setVisible(true);
                labelname.setText(student.get(0));
                labelfname.setText(student.get(1));
                labelphone.setText(student.get(2));
                labeladdress.setText(student.get(3));
                labeldegree.setText(student.get(4));
                labelgender.setText(student.get(5));
                labelmail.setText(student.get(6));
                labelcnic.setText(student.get(7));
                labelDOB.setText(student.get(8));
            }
        } else {
            detailslabel.setText("enter valid cnic");
        }


    }


// Display FXML START====================================================================================================
}
