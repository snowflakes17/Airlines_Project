package com.project.controller;

import com.project.models.Customer;
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
import java.sql.SQLException;

public class UserPageMyFlight_Controller {


    private Stage stage;
    private Parent root;
    private Scene scene;

    private Customer customer;


    public void setCustomer(Customer customer) throws SQLException {
        this.customer = customer;
        user_Name.setText(customer.getFirstName() + customer.getLastName());
        Email.setText(customer.getEmail());
    }
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

    public void switchTo(MouseEvent event, String to) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(to));
        root = loader.load();
        if (to.equals("User_Page_Checki_in.fxml")){
            UserPageCheckInController a= loader.getController();
            a.setCustomer(customer);
        }
        if (to.equals("User_Page.fxml")){
            UserPage_Controller a= loader.getController();
            a.setCustomer(customer);
        }
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
