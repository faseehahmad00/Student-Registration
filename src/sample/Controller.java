package sample;
import com.jfoenix.controls.JFXDatePicker;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import org.sqlite.core.DB;

public class Controller {
    @FXML
    private PasswordField passwordField = new PasswordField();
    @FXML
    private TextField textField = new TextField();
    @FXML
    private TextField name = new TextField();
    @FXML
    private TextField ID = new TextField();
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
    String gender;
    String degree;
    DataBase database = new DataBase();
    //buttons,textfiels etc
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
//LOGIN FORM END========================================================================================================


    ///MENU BAR START=======================================================================================================
    public void add() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("regform.fxml"));
            Main.primaryStage.setScene(new Scene(root));
        } catch (Exception ignored) {
        }

    }

    public void delete() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
            Main.primaryStage.setScene(new Scene(root));
        } catch (Exception ignored) {
        }

    }

    public void logout() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
            Main.primaryStage.setScene(new Scene(root));
        } catch (Exception ignored) {
        }

    }
//MENU BAR END==========================================================================================================


    //REGISTRATION FORM START===============================================================================================
    public void oncancel() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Main.primaryStage.setScene(new Scene(root));
        } catch (Exception ignored) {
        }
    }

    public void onsaveclicked() {//on pressing save button on registration form.
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
        if (name.getText().isEmpty() || degree.isEmpty() || fname.getText().isEmpty() || ID.getText().isEmpty() ||
                gender.isEmpty() || phone.getText().isEmpty() || address.getText().isEmpty() || cnic.getText().isEmpty()
                || email.getText().isEmpty()) {
            emptyfield.setText("please fill all reqiured fields to continue");
            database.insert("faseeh","azhar");
        } else {
            System.out.println(ID.getText());
            System.out.println(name.getText());
            System.out.println(fname.getText());
            System.out.println(cnic.getText());
            System.out.println(phone.getText());
            System.out.println(address.getText());
            System.out.println(email.getText());//printing details on terminal.
            System.out.println(gender);
            System.out.println(degree);
           // System.out.println(date);


            try {
                Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                Main.primaryStage.setScene(new Scene(root));
            } catch (Exception ignored) {
            }
        }
    }

//REGISTRATION FORM END=================================================================================================
    // }

}
