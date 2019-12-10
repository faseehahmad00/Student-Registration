package sample;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Controller {
   private regcontrol reg = new regcontrol();
    private menucontrol menu = new menucontrol();                        //st1 is object of of stagecontrol(stcontrol) class
    private Remove remove = new Remove();
    private signcontrol signin = new signcontrol();
    @FXML
    private PasswordField passwordField = new PasswordField();
    @FXML
    private TextField textField = new TextField();
//    @FXML
//    private Label label = new Label();
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
    private RadioButton bscs = new RadioButton();
    @FXML
    private RadioButton bsse = new RadioButton();
    @FXML
    String gender;
    String degree;


    private static Stage stage = new Stage();                                                     //buttons,textfiels etc

    //LOGIN FORM START======================================================================================================
    public void onexitclick() {
        Platform.exit();
    }

    public void onclick(){
        String passcode = "";
        String username = "";
        if (passcode.equals(passwordField.getText()) && username.equals(textField.getText())) {
            System.out.println("login successful");
            errormsg.setText("login Successful");

            try {
                menu.start(stage);
                Main.close();
            }catch (Exception e){}
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
            reg.start(stage);
        } catch (Exception e) {}

    }

    public void delete() {
        try {
            remove.start(stage);
        } catch (Exception e) {}

    }

    public void logout() {
        try {
            signin.start(stage);
        } catch (Exception e) {}

    }
//MENU BAR END==========================================================================================================


    //REGISTRATION FORM START===============================================================================================
    public void oncancel() {
        try {
            menu.start(stage);
        } catch (Exception e) {}
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
        //radio button functions
        if (name.getText().isEmpty() || degree.isEmpty()|| fname.getText().isEmpty() ||ID.getText().isEmpty()
                || phone.getText().isEmpty() || address.getText().isEmpty() || cnic.getText().isEmpty())
        {
            emptyfield.setText("please fill all reqiured fields to continue"); }
        else {
            System.out.println(ID.getText());
            System.out.println(name.getText());
            System.out.println(fname.getText());
            System.out.println(cnic.getText());
            System.out.println(phone.getText());
            System.out.println(address.getText());
            System.out.println(email.getText());//printing details on terminal.
            System.out.println(gender);
            System.out.println(degree);
            try {
                menu.start(stage);
                }
            catch (Exception e) {}
            }
        }

//REGISTRATION FORM END=================================================================================================
    }


