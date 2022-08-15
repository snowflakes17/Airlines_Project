package com.project.controller;

import com.project.models.Customer;
import com.project.models.Flight;
import com.project.models.Ticket;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class UserPageMyFlight_Controller implements Initializable {


    private Stage stage;
    private Parent root;
    private Scene scene;

    private Customer customer;

    private ObservableList<Ticket> ResultList = FXCollections.observableArrayList();

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
    private ImageView Dubai;

    @FXML
    private Label Email;

    @FXML
    private Label Email1;

    @FXML
    private TableColumn<Flight, Integer> F_No;

    @FXML
    private MFXButton Find_Flight;

    @FXML
    private ImageView Instanbul;

    @FXML
    private MFXButton Logout;

    @FXML
    private ImageView MyTrips2;

    @FXML
    private TextField Ref;

    @FXML
    private TableView<Ticket> Table;

    @FXML
    private TableColumn<Ticket, Date> date;

    @FXML
    private TableColumn<Ticket, String> seat;

    @FXML
    private TableColumn<Ticket, String> from;

    @FXML
    private TextField last_name;

    @FXML
    private ImageView next;

    @FXML
    private TableColumn<Flight, String> to;

    @FXML
    private Label user_Name;



    @FXML
    void Dubai(MouseEvent event) {

    }

    @FXML
    void Istanbul(MouseEvent event) {

    }

    @FXML
    void next(MouseEvent event) {

    }

    @FXML
    void searchbyref(MouseEvent event) {

    }

    public void setFlights(ArrayList<Ticket> flights) throws SQLException {
        for (Ticket f:
                flights) {
            ResultList.add(f);
        }
    }

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        F_No.setCellValueFactory(new PropertyValueFactory<>("ticket_id"));
        to.setCellValueFactory(new PropertyValueFactory<>("passenger_id"));
        from.setCellValueFactory(new PropertyValueFactory<>("flight_number"));
        date.setCellValueFactory(new PropertyValueFactory<>("purchase_date"));
        seat.setCellValueFactory(new PropertyValueFactory<>("seat_row"));
        Table.setItems(ResultList);
    }
}
