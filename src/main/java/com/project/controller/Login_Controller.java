package com.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Login_Controller {

    private Scene scene;
    private Parent root;
    private Stage stage;

    public void switchToUserPage(ActionEvent event) throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private ImageView Choose_Admin;

    @FXML
    private ImageView Choose_User;

    @FXML
    private Button Login;

    @FXML
    private Button Sign_Up;

    @FXML
    private Button frgt;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField uname_field;

    @FXML
    void Admin(MouseEvent event) {
        System.out.println("check");
    }

    @FXML
    void Forgot(ActionEvent event) {
        System.out.println("check");
    }

    @FXML
    void Login(ActionEvent event) throws IOException{
        
        String u_n = uname_field.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("User_Page.fxml"));
        root = loader.load();

        try {
            switchToUserPage(event);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void Sign_up_Scene(ActionEvent event) {
        System.out.println("check");
    }

    @FXML
    void User(MouseEvent event) {
        System.out.println("check");
    }
    
}
