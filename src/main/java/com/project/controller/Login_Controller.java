package com.project.controller;

import com.project.models.Customer;
import com.project.models.Flight;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.mindrot.jbcrypt.BCrypt;

import java.awt.datatransfer.FlavorListener;
import java.sql.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Login_Controller implements Initializable {

    private Scene scene;
    private Parent root;
    private Stage stage;




    public void switchPage(ActionEvent event) throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private ImageView Choose_Admin;

    @FXML
    private ImageView passwd_bg;
    @FXML
    private ImageView Choose_User;

    @FXML
    private Label err;
    @FXML
    private ImageView usr_name_bg;
    @FXML
    private MFXButton Login;

    @FXML
    private Button Sign_Up;

    @FXML
    private PasswordField password_field;

    @FXML
    private ImageView Login_Lbl;
    @FXML
    private TextField uname_field;

    void animation(boolean check){
        int x = check ? 70 : -72;
        Node y = check ? Choose_Admin : Choose_User;
        List<Node> Fade = new ArrayList<Node>();
        Fade.add(usr_name_bg);
        Fade.add(passwd_bg);
        Fade.add(password_field);
        Fade.add(uname_field);
        Fade.add(Login);
        Fade.add(Sign_Up);
        for (Node i :
                Fade) {
            i.setVisible(true);
            FadeTransition fd = new FadeTransition(Duration.millis(1200),i);
            fd.setFromValue(0);
            fd.setToValue(1);
            fd.playFromStart();
        }
        TranslateTransition lbl = new TranslateTransition(Duration.millis(1100),Login_Lbl);
        lbl.setFromY(y.getTranslateY());
        lbl.setToY(y.getTranslateY() - 75);
        lbl.playFromStart();
        TranslateTransition s = new TranslateTransition(Duration.millis(700),y);
        s.setFromY(y.getTranslateY());
        s.setToY(y.getTranslateY() - 95);
        s.playFromStart();
//        TranslateTransition sa = new TranslateTransition(Duration.millis(600),y);
//        sa.setDelay(Duration.millis(600));
//        sa.setFromX(y.getTranslateX());
//        sa.setToX(y.getTranslateX() - x);
//        sa.playFromStart();
        y.setDisable(true);
    }
    @FXML
    void Admin(MouseEvent event) {
        animation(true);
        Choose_Admin.setId("static");
        Choose_User.setVisible(false);
    }


    @FXML
    void Login(ActionEvent event) throws IOException,SQLException{

        Statement s = ConnectDB.getConnection();
        PreparedStatement get_email = s.getConnection().prepareStatement("SELECT passenger_email from `Passenger` WHERE passenger_email = '" + uname_field.getText() +"'");
        PreparedStatement get_pass = s.getConnection().prepareStatement("SELECT passenger_password from `Passenger`WHERE passenger_email = '" + uname_field.getText() +"'");
        ResultSet get_e = get_email.executeQuery();
        ResultSet get_p = get_pass.executeQuery();
        String password = password_field.getText();
        String email = uname_field.getText();
        if (get_e.next()) {
            String user = get_e.getString("passenger_email");
            System.out.println(user);
            if (user.equals(email)) {
                if(get_p.next()){
                    String bcryptHashString = get_p.getString("passenger_password");
                    System.out.println(bcryptHashString);
                    if (BCrypt.checkpw(password, bcryptHashString)) {
                        PreparedStatement get_all = s.getConnection().prepareStatement("SELECT * from `Passenger`WHERE passenger_email = '" + uname_field.getText() +"'");
                        ResultSet get_a = get_all.executeQuery();
                        try {
                            ArrayList<Flight> pass = new ArrayList<Flight>();
                            if (get_a.next()){
                                Customer addis = new Customer(get_a);
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("User_Page.fxml"));
                                root = (Parent) loader.load();
                                UserPage_Controller a= loader.getController();
                                a.setCustomer(addis);
                                switchPage(event);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        err.setText("Wrong password combination");
                        err.setVisible(true);
                    }
                }
            }
        }
        else {
            err.setText("No user found with this email");
            err.setVisible(true);
        }
    }

    @FXML
    void Sign_up_Scene(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
        root = loader.load();
        try {
            switchPage(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void User(MouseEvent event) {
        animation(false);
        Choose_User.setId("static");
        Choose_Admin.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }


}
