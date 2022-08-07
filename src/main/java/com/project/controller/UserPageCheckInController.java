package com.project.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
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

public class UserPageCheckInController {


    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private ImageView Book;

    @FXML
    private TextField Booking;

    @FXML
    private ImageView Check;

    @FXML
    private MFXButton Continues;

    @FXML
    private Label Email;

    @FXML
    private TextField Last;

    @FXML
    private MFXButton Logout;

    @FXML
    private ImageView MyTrips;

    @FXML
    private Label Ref;

    @FXML
    private Label Ticket;

    @FXML
    private ImageView tab1;

    @FXML
    private ImageView tab2;

    @FXML
    private Label user_Name;


    public void switchPage(MouseEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
    void Logout(MouseEvent event) {
        try {
            switchTo(event,"Login.fxml");
        } catch (Exception e) {
            e.printStackTrace();}
    }

    @FXML
    void MyTrip(MouseEvent event){
        try {
            switchTo(event,"User_Page_My_Trip.fxml");
        } catch (Exception e) {
            e.printStackTrace();}
    }

}
