package com.project.controller;

import com.project.models.Customer;
import com.project.models.Flight;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

public class UserPageChoose_Controller {

    private Scene scene;
    private Stage stage;
    private Parent root;
    private Customer customer;
    private Flight flight;

    @FXML
    private ImageView Book;

    @FXML
    private ImageView Checkin;

    @FXML
    private MFXButton Choose_seat;

    @FXML
    private Label Choosen;

    @FXML
    private Label Choosen_Label;

    @FXML
    private Label Destination;

    @FXML
    private Label Email;

    @FXML
    private Label Email1;

    @FXML
    private MFXButton Logout;

    @FXML
    private ImageView MyTrips;

    @FXML
    private Label Name;

    @FXML
    private Label Name1;

    @FXML
    private Label Name11;

    @FXML
    private Label Name5;

    @FXML
    private MFXButton Pay;

    @FXML
    private MFXButton Pay1;

    @FXML
    private Button PlaceSeat;

    @FXML
    private Label Seat;

    @FXML
    private Label Source;

    @FXML
    private Label TD;

    @FXML
    private Label TicketNo;

    @FXML
    private ImageView bg;

    @FXML
    private ImageView black2;

    @FXML
    private ImageView cover1;

    @FXML
    private ImageView cover10;

    @FXML
    private ImageView cover11;

    @FXML
    private ImageView cover12;

    @FXML
    private ImageView cover13;

    @FXML
    private ImageView cover14;

    @FXML
    private ImageView cover15;

    @FXML
    private ImageView cover16;

    @FXML
    private ImageView cover17;

    @FXML
    private ImageView cover18;

    @FXML
    private ImageView cover19;

    @FXML
    private ImageView cover2;

    @FXML
    private ImageView cover20;

    @FXML
    private ImageView cover21;

    @FXML
    private ImageView cover22;

    @FXML
    private ImageView cover23;

    @FXML
    private ImageView cover24;

    @FXML
    private ImageView cover25;

    @FXML
    private ImageView cover26;

    @FXML
    private ImageView cover27;

    @FXML
    private ImageView cover28;

    @FXML
    private ImageView cover29;

    @FXML
    private ImageView cover3;

    @FXML
    private ImageView cover30;

    @FXML
    private ImageView cover4;

    @FXML
    private ImageView cover5;

    @FXML
    private ImageView cover6;

    @FXML
    private ImageView cover7;

    @FXML
    private ImageView cover8;

    @FXML
    private ImageView cover9;

    @FXML
    private Label dummy1;

    @FXML
    private Label dummy2;

    @FXML
    private Label dummy3;

    @FXML
    private Label dummy4;

    @FXML
    private Label dummy5;

    @FXML
    private Label dummy6;

    @FXML
    private Label errBalance;

    @FXML
    private Label group;

    @FXML
    private ImageView icon_warn;

    @FXML
    private Label label_warn1;

    @FXML
    private Label label_warn2;

    @FXML
    private Label label_warn3;

    @FXML
    private Label label_warn4;

    @FXML
    private Label nothing1;

    @FXML
    private ImageView nothing2;

    @FXML
    private Label nothing3;

    @FXML
    private Label nothing4;

    @FXML
    private Label nothing5;

    @FXML
    private ImageView nothing6;

    @FXML
    private ImageView nothing7;

    @FXML
    private ImageView nothing71;

    @FXML
    private ImageView nothing8;

    @FXML
    private AnchorPane orange;

    @FXML
    private Label price;

    @FXML
    private ImageView spliter2;

    @FXML
    private ImageView tik;

    @FXML
    private AnchorPane user;

    @FXML
    private Label user_Name;


    @FXML
    void CheckIn(MouseEvent event) {
        try {
            switchTo(event,"User_Page_Checki_in.fxml");
        } catch (Exception e) {
            e.printStackTrace();}
    }
    void setFlight(Flight f){
        this.flight = f;
        Name1.setText(f.getFlightFrom().split(",")[0] + " to " + f.getFlightTo().split(",")[0] + " / $" + f.getFlightPrice());
        Random rand = new Random();
        int possbleRegNo = rand.nextInt(10000);
        Name11.setText("R-" + possbleRegNo);
    }
    void setName(Customer u){
        this.customer = u;
        user_Name.setText(customer.getFirstName() + customer.getLastName());
        Email.setText(customer.getEmail());
        Name.setText(customer.getFirstName() + " / " + customer.getLastName());
        Email1.setText(String.valueOf(customer.getBalance()));
        Seat.setText(Choosen.getText());
    }

    @FXML
    void choosed(MouseEvent event){
        Map<ImageView, String> covers = new HashMap<ImageView, String >();
        covers.put(cover1,"2A");
        covers.put(cover2,"2D");
        covers.put(cover3,"2F");
        covers.put(cover4,"3F");
        covers.put(cover5,"3D");
        covers.put(cover6,"3A");
        covers.put(cover7,"4A");
        covers.put(cover8,"4D");
        covers.put(cover9,"4F");
        covers.put(cover10,"5A");
        covers.put(cover11,"5D");
        covers.put(cover12,"5F");
        covers.put(cover13,"6A");
        covers.put(cover14,"6D");
        covers.put(cover15,"6F");
        covers.put(cover16,"7A");
        covers.put(cover17,"7D");
        covers.put(cover18,"7F");
        covers.put(cover19,"8A");
        covers.put(cover20,"8D");
        covers.put(cover21,"8F");
        covers.put(cover22,"9A");
        covers.put(cover23,"9D");
        covers.put(cover24,"9F");
        covers.put(cover25,"10A");
        covers.put(cover26,"10D");
        covers.put(cover27,"10F");
        covers.put(cover28,"11A");
        covers.put(cover29,"11D");
        covers.put(cover30,"11F");
        ArrayList<Node> on= new ArrayList<Node>();
        on.add(icon_warn);
        on.add(label_warn1);
        on.add(label_warn3);
        on.add(label_warn4);
        black2.setVisible(true);
        Choosen.setVisible(true);
        for (Node k: on) {
            k.setDisable(false);
            k.setVisible(true);
        }
        Choosen.setText(covers.get((ImageView)(event.getSource())));
        if (((ImageView)event.getSource()).getOpacity() != 0.6){
            for (Node k: on) {
                k.setDisable(true);
                k.setVisible(false);
            }
            tik.setVisible(true);
            for (ImageView o:
            covers.keySet()) {
                if (o.getOpacity() == 1){
                    o.setOpacity(0);
                }
            }
            ((ImageView)event.getSource()).setOpacity(1);
            Seat.setText(covers.get((ImageView)event.getSource()));
            PlaceSeat.setDisable(false);
        }
        else{
            tik.setVisible(false);
            PlaceSeat.setDisable(true);
        }
    }

    @FXML
    void GotoChoose(MouseEvent event) throws FileNotFoundException, SQLException {
        Statement s = ConnectDB.getConnection();
        Map<String, ImageView> covers = new HashMap<String, ImageView>();
        covers.put("2A",cover1);
        covers.put("2D",cover2);
        covers.put("2F",cover3);
        covers.put("3F",cover4);
        covers.put("3D",cover5);
        covers.put("3A",cover6);
        covers.put("4A",cover7);
        covers.put("4D",cover8);
        covers.put("4F",cover9);
        covers.put("5A",cover10);
        covers.put("5D",cover11);
        covers.put("5F",cover12);
        covers.put("6A",cover13);
        covers.put("6D",cover14);
        covers.put("6F",cover15);
        covers.put("7A",cover16);
        covers.put("7D",cover17);
        covers.put("7F",cover18);
        covers.put("8A",cover19);
        covers.put("8D",cover20);
        covers.put("8F",cover21);
        covers.put("9A",cover22);
        covers.put("9D",cover23);
        covers.put("9F",cover24);
        covers.put("10A",cover25);
        covers.put("10D",cover26);
        covers.put("10F",cover27);
        covers.put("11A",cover28);
        covers.put("11D",cover29);
        covers.put("11F",cover30);
        PreparedStatement p = s.getConnection().prepareStatement("select * from `Ticket`");
        ResultSet u = p.executeQuery();
        while (u.next()){
            covers.get(u.getString("seat_row")).setOpacity(0.6);
        }
        ArrayList<Node> off= new ArrayList<Node>();
        off.add(nothing1);
        off.add(nothing2);
        off.add(nothing3);
        off.add(nothing4);
        off.add(nothing5);
        off.add(nothing6);
        off.add(nothing7);
        off.add(nothing8);
        off.add(Pay);
        off.add(Name);
        off.add(group);
        off.add(Name11);
        off.add(Name1);
        off.add(Choose_seat);
        for (Node node:off) {
            node.setVisible(false);
            node.setDisable(true);
        }
        InputStream stream = new FileInputStream("/home/nahomd/IdeaProjects/Airlines_Project/src/main/resources/com/project/controller/Assests/Rectangle 18 (1).png");
        Image image = new Image(stream);
        bg.setImage(image);
        bg.setBlendMode(BlendMode.MULTIPLY);
        ArrayList<Node> on= new ArrayList<Node>();
        on.add(Choosen_Label);
        on.add(spliter2);
        on.add(label_warn2);
        on.add(PlaceSeat);
        for (Node node:on) {
            node.setVisible(true);
            node.setDisable(false);
        }
    }

    @FXML
    void gotopay(MouseEvent event) throws SQLException {
        Map<String, Boolean> covers = new HashMap<String, Boolean>();
        covers.put("2A",true);
        covers.put("2D",true);
        covers.put("2F",true);
        covers.put("3F",true);
        covers.put("3D",true);
        covers.put("3A",true);
        covers.put("4A",true);
        covers.put("4D",true);
        covers.put("4F",true);
        covers.put("5A",true);
        covers.put("5D",true);
        covers.put("5F",true);
        covers.put("6A",true);
        covers.put("6D",true);
        covers.put("6F",true);
        covers.put("7A",true);
        covers.put("7D",true);
        covers.put("7F",true);
        covers.put("8A",true);
        covers.put("8D",true);
        covers.put("8F",true);
        covers.put("9A",true);
        covers.put("9D",true);
        covers.put("9F",true);
        covers.put("10A",true);
        covers.put("10D",true);
        covers.put("10F",true);
        covers.put("11A",true);
        covers.put("11D",true);
        covers.put("11F",true);
        ArrayList<Node> off= new ArrayList<Node>();
        off.add(nothing1);
        off.add(nothing2);
        off.add(nothing3);
        off.add(nothing4);
        off.add(nothing5);
        off.add(nothing6);
        off.add(nothing7);
        off.add(nothing8);
        off.add(Pay);
        off.add(Name);
        off.add(group);
        off.add(Name11);
        off.add(Name1);
        off.add(Choose_seat);
        for (Node node:off) {
            node.setVisible(false);
            node.setDisable(true);
        }
        off.clear();
        off.add(TD);
        off.add(nothing71);
        off.add(dummy1);
        off.add(dummy2);
        off.add(dummy3);
        off.add(dummy4);
        off.add(dummy5);
        off.add(dummy6);
        off.add(TicketNo);
        off.add(Name5);
        off.add(price);
        off.add(Source);
        off.add(Destination);
        off.add(Seat);
        off.add(Pay1);
        for (Node node:off) {
            node.setVisible(true);
            node.setDisable(false);
        }
        if (customer.getBalance() < flight.getFlightPrice()){
            Pay1.setDisable(true);
        }
        Random n = new Random();
        TicketNo.setText("TID" + (n.nextInt(100)));
        Source.setText(flight.getFlightFrom());
        Destination.setText(flight.getFlightTo());
        Name5.setText(customer.getFirstName() + " " + customer.getLastName());
        price.setText("$" + flight.getFlightPrice());

        if (Seat.getText().equals("none")) {
            Statement s = ConnectDB.getConnection();
            PreparedStatement p = s.getConnection().prepareStatement("select * from `Ticket`");
            ResultSet u = p.executeQuery();
            while (u.next()) {
                for (String r :
                        covers.keySet()) {
                    if (r.equals(u.getString("seat_row"))) {
                        covers.put(r, false);
                    }
                }
            }

            for (String f :
                    covers.keySet()) {
                if (covers.get(f)) {
                    Seat.setText(f);
                }
            }
        }
    }

    @FXML
    void Logout(MouseEvent event) {
        try {
            switchTo(event,"Login.fxml");
        } catch (Exception e) {
            e.printStackTrace();}
    }

    private void switchTo(MouseEvent event, String to) throws IOException, SQLException {
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

    public void switchPage(MouseEvent event) throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void MyTrip(MouseEvent event) {
        try {
            switchTo(event,"User_Page_My_Trip.fxml");
        } catch (Exception e) {
            e.printStackTrace();}
    }

    @FXML
    void PlaceSeat(MouseEvent event) throws FileNotFoundException {
        if (!(label_warn1.isVisible())){
            ArrayList<Node> off= new ArrayList<Node>();
            off.add(nothing1);
            off.add(nothing2);
            off.add(nothing3);
            off.add(nothing4);
            off.add(nothing5);
            off.add(nothing6);
            off.add(nothing7);
            off.add(nothing8);
            off.add(Pay);
            off.add(Name);
            off.add(group);
            off.add(Name11);
            off.add(Name1);
            off.add(Choose_seat);
            for (Node node:off) {
                node.setVisible(true);
                node.setDisable(false);
            }
            InputStream stream = new FileInputStream("/home/nahomd/IdeaProjects/Airlines_Project/src/main/resources/com/project/controller/Assests/Rectangle 18.png");
            Image image = new Image(stream);
            bg.setImage(image);
            bg.setBlendMode(BlendMode.SRC_OVER);
            ArrayList<Node> on= new ArrayList<Node>();
            on.add(Choosen_Label);
            on.add(spliter2);
            on.add(black2);
            on.add(label_warn2);
            on.add(Choosen);
            on.add(PlaceSeat);
            for (Node node:on) {
                node.setVisible(false);
                node.setDisable(true);
            }
            Map<ImageView, String> covers = new HashMap<ImageView, String >();
            covers.put(cover1,"2A");
            covers.put(cover2,"2D");
            covers.put(cover3,"2F");
            covers.put(cover4,"3F");
            covers.put(cover5,"3D");
            covers.put(cover6,"3A");
            covers.put(cover7,"4A");
            covers.put(cover8,"4D");
            covers.put(cover9,"4F");
            covers.put(cover10,"5A");
            covers.put(cover11,"5D");
            covers.put(cover12,"5F");
            covers.put(cover13,"6A");
            covers.put(cover14,"6D");
            covers.put(cover15,"6F");
            covers.put(cover16,"7A");
            covers.put(cover17,"7D");
            covers.put(cover18,"7F");
            covers.put(cover19,"8A");
            covers.put(cover20,"8D");
            covers.put(cover21,"8F");
            covers.put(cover22,"9A");
            covers.put(cover23,"9D");
            covers.put(cover24,"9F");
            covers.put(cover25,"10A");
            covers.put(cover26,"10D");
            covers.put(cover27,"10F");
            covers.put(cover28,"11A");
            covers.put(cover29,"11D");
            covers.put(cover30,"11F");
            for (ImageView o:
                    covers.keySet()) {
                if (o.getOpacity() != 0){
                    o.setOpacity(0);
                }
            }
            tik.setVisible(false);
        }
    }

    @FXML
    void GetTicket(MouseEvent event) throws SQLException, IOException, InterruptedException {
        if (customer.getBalance() > flight.getFlightPrice()){
            customer.setBalance(customer.getBalance() - flight.getFlightPrice());
            Email1.setText(String.valueOf(customer.getBalance()));
            Statement s = ConnectDB.getConnection();
            PreparedStatement get_email = s.getConnection().prepareStatement("INSERT INTO `Ticket`(ticket_id,passenger_id,flight_number,purchase_date,seat_row) values ('"+TicketNo.getText() + "', " + customer.getUserId() + ", "  + flight.getFlightNumber() + ", '" + Date.valueOf(LocalDate.now()) + "', '" + Seat.getText() +"')");
            get_email.execute();
            switchTo(event, "User_Page.fxml");
        }
        else {
            errBalance.setVisible(true);
        }
    }
}
