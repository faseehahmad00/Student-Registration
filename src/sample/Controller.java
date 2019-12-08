package sample;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller {

    regcontrol reg = new regcontrol();
    menucontrol menu = new menucontrol();                        //st1 is object of of stagecontrol(stcontrol) class
    Remove remove = new Remove();
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
    JFXComboBox<String> gender = new JFXComboBox<String>();
    @FXML
    JFXDatePicker dob = new JFXDatePicker();
    @FXML
    TextField degree = new TextField();
    @FXML
    TextField cnic = new TextField();
    @FXML
    Text errormsg = new Text();
    @FXML
//    static Stage stagemenu = new Stage();
//    public Stage stagereg = new Stage();
//    public Stage stagerem = new Stage();
//    public Stage signin = new Stage();
    static Stage stage = new Stage();
    ;                                                        //buttons,textfiels etc


//LOGIN FORM START======================================================================================================
        public void onexitclick () { Platform.exit(); }
        public void onclick () throws Exception {
            String passcode = "admin";
            String username = "admin";
            if (passcode.equals(passwordField.getText()) && username.equals(textField.getText())) {
                System.out.println("login successful");
                errormsg.setText("login Successful");
                menu.start(stage);
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
        public void add () throws Exception {
            reg.start(stage);
        }
        public void delete () throws Exception{
            remove.start(stage);
        }
        public void logout () throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
            stage.setTitle("WELCOME TO STUDENT REGISTRATION");
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            stage.setFullScreen(true);

        }
//MENU BAR END==========================================================================================================


//REGISTRATION FORM START===============================================================================================
        public void oncancel () throws Exception {
            menu.start(stage);
        }

        public void onsaveclicked () {                   //on pressing save button on registration form.
            System.out.println(label.getText());
            System.out.println(name.getText());
            System.out.println(fname.getText());
            System.out.println(cnic.getText());
            System.out.println(phone.getText());
            System.out.println(address.getText());
            System.out.println(degree.getText());
            System.out.println(email.getText());                                         //printing details on terminal.
        }
//REGISTRATION FORM END=================================================================================================

    }
