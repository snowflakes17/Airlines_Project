package com.project.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.objects.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class UserPage_Controller implements Initializable{

    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private Button Logout;

    @FXML
    Label user_Name;

    public void switchPage(ActionEvent event) throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Logout(ActionEvent event) {
        try {
            switchToLogin(event);
        } catch (Exception e) {
            e.printStackTrace();}

        user_Name.setText("Nahom");
        System.out.println(user_Name.getText());
    }

    public void switchToLogin(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        root = loader.load();
        try {
            switchPage(event);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void changeName(Customer who) {
         user_Name.setText(String.valueOf(who.getFirstName()));
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        
    }

}
