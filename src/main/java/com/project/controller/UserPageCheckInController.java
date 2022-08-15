package com.project.controller;

import com.project.models.Customer;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class UserPageCheckInController {


    private Scene scene;
    private Stage stage;
    private Parent root;

    private Customer customer;

    public void setCustomer(Customer customer) throws SQLException {
        this.customer = customer;
        user_Name.setText(customer.getFirstName() + customer.getLastName());
        Email.setText(customer.getEmail());
        Balance.setText(String.valueOf(customer.getBalance()));
    }
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
    private Label Balance;

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

    private boolean toggle = false;

    public void switchPage(MouseEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchTo(MouseEvent event, String to) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(to));
        root = loader.load();
        if (to.equals("User_Page.fxml")){
            UserPage_Controller a= loader.getController();
            a.setCustomer(customer);
        }
        if (to.equals("User_Page_My_Trip.fxml")){
            UserPageMyFlight_Controller a= loader.getController();
            a.setCustomer(customer);
        }
        try {
            switchPage(event);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void toggle(MouseEvent event) {
        if (!toggle){
            tab1.setDisable(false);
            tab2.setVisible(false);
            tab2.setDisable(true);
            tab1.setVisible(true);
            Ref.setTextFill(Color.BLACK);
            Ticket.setTextFill(Color.WHITE);
        }
        else{
            tab2.setDisable(false);
            tab1.setVisible(false);
            tab1.setDisable(true);
            tab2.setVisible(true);
            Ref.setTextFill(Color.WHITE);
            Ticket.setTextFill(Color.BLACK);
        }
        toggle = !toggle;
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
