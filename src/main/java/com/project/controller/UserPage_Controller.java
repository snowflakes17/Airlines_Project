package com.project.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.project.models.Customer;
import com.project.models.Flight;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class UserPage_Controller implements Initializable{
    private Scene scene;
    private Stage stage;
    private Parent root;
    private Customer customer;

    private Flight flights;

    @FXML
    private ImageView Book;

    @FXML
    private RadioButton Both;

    @FXML
    private RadioButton Business;

    @FXML
    private ImageView Checkin;

    @FXML
    private DatePicker Depart_Date;

    @FXML
    private RadioButton Economy;

    @FXML
    private Label Email;

    @FXML
    private MFXButton Find_Flight;

    @FXML
    private MFXButton Logout;

    @FXML
    private ImageView MyTrips;

    @FXML
    private MenuButton No_of_people;

    @FXML
    private TableView<?> Results;

    @FXML
    private ToggleGroup Type;

    @FXML
    private TextField Where_From;

    @FXML
    private TextField Where_To;

    @FXML
    private Label user_Name;

    public void setCustomer(Customer customer) throws SQLException {
        this.customer = customer;
        user_Name.setText(customer.getFirstName() + customer.getLastName());
        Email.setText(customer.getEmail());
    }

    public void setFlights(Flight flights) throws SQLException {
        this.flights = flights;
    }

    @FXML
    void Search(MouseEvent event){
        ArrayList<Node> off= new ArrayList<Node>();
        off.add(Where_From);
        off.add(Where_To);
        off.add(No_of_people);
        off.add(Depart_Date);
        off.add(Economy);
        off.add(Business);
        off.add(Both);
        for (Node node:off) {
            node.setVisible(false);
        }
        Results.setVisible(true);
        Results.setDisable(false);
    }

    public void switchPage(MouseEvent event) throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
