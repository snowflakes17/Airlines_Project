package com.project.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.project.models.Customer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class UserPage_Controller implements Initializable{
    private Scene scene;
    private Stage stage;
    private Parent root;
    private Customer customer;



    @FXML
    private Button Logout;

    @FXML
    Label user_Name;

    @FXML
    Label Email;

    public void setCustomer(Customer customer) throws SQLException {
        this.customer = customer;
        user_Name.setText(customer.getFirstName() + customer.getLastName());
        Email.setText(customer.getEmail());
    }

    public void switchPage(MouseEvent event) throws IOException{
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
    void Logout(MouseEvent event) {
        try {
            switchTo(event,"Login.fxml");
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
    void MyTrip(MouseEvent event){
        try {
            switchTo(event,"User_Page_My_Trip.fxml");
        } catch (Exception e) {
            e.printStackTrace();}
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {}

}
