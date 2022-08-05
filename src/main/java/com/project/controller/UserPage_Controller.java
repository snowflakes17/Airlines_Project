package com.project.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.project.objects.Customer;
import javafx.application.Platform;
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

import javax.swing.table.TableCellRenderer;

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

    public void setCustomer(Customer customer) throws SQLException {
        this.customer = customer;
        user_Name.setText(customer.getFirstName() + customer.getLastName());
        Email.setText(customer.getEmail());
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {}

}
