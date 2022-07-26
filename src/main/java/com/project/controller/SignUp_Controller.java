package com.project.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUp_Controller {

    private Parent root;
    private Stage stage;
    private Scene scene;


    @FXML
    private MFXButton Back;

    @FXML
    private MFXDatePicker BirthDate;

    @FXML
    private MFXTextField FullName;

    @FXML
    private MFXTextField PassportNo;

    @FXML
    private MFXButton SignUp;

    @FXML
    private MFXTextField email;

    @FXML
    private MFXPasswordField password;

    @FXML
    void SignUp(ActionEvent event) {
        System.out.println("Check");
    }

    public void switchPage(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backToLogin(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        root = loader.load();
        try {
            switchPage(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}