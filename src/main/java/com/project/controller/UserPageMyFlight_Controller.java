package com.project.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class UserPageMyFlight_Controller {


    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private ImageView Book;

    @FXML
    private ImageView Checkin;

    @FXML
    private Label Email;

    @FXML
    private MFXButton Find_Flight;

    @FXML
    private MFXButton Logout;

    @FXML
    private ImageView MyTrips2;

    @FXML
    private TextField Where_From;

    @FXML
    private TextField Where_To;

    @FXML
    private Label user_Name;

    public void switchPage(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchTo(MouseEvent event, String to) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(to));
        root = loader.load();
        try {
            switchPage(event);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void Book(MouseEvent event) {
        try {
            switchTo(event,"User_Page.fxml");
        } catch (Exception e) {
            e.printStackTrace();}
    }

    @FXML
    void CheckIn(MouseEvent event){
        try {
            switchTo(event,"User_Page_Checki_in.fxml");
        } catch (Exception e) {
            e.printStackTrace();}
    }

    @FXML
    void Logout(MouseEvent event) {
        try {
            switchTo(event,"Login.fxml");
        } catch (Exception e) {
            e.printStackTrace();}
    }

}
