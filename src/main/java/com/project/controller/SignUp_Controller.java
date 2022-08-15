package com.project.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class SignUp_Controller implements Initializable {

    private Parent root;
    private Stage stage;
    private Scene scene;


    @FXML
    private ImageView Approved;

    @FXML
    private MFXButton Back;

    @FXML
    private DatePicker BirthDate;

    @FXML
    private MFXComboBox Gender;
    @FXML
    private MFXTextField FullName;

    @FXML
    private Label Must1;

    @FXML
    private Label Must2;

    @FXML
    private Label Must3;

    @FXML
    private Label Must4;

    @FXML
    private Label Must5;
    @FXML
    private MFXTextField PassportNo;

    @FXML
    private MFXButton SignUp;

    @FXML
    private Label Signup_lbl;

    @FXML
    private Button backL;

    @FXML
    private ImageView box1;

    @FXML
    private ImageView box2;

    @FXML
    private ImageView box3;

    @FXML
    private ImageView box4;

    @FXML
    private ImageView box5;

    @FXML
    private ImageView box6;

    @FXML
    private MFXTextField email;

    @FXML
    private MFXPasswordField password;


    @FXML
    void SignUp(ActionEvent event) {

        if ( FullName.getText() == "" || password.getText() == "" || email.getText() == "" || BirthDate.getValue() == null ){
            if (FullName.getText() == "")
                Must1.setVisible(true);
            else Must1.setVisible(false);
            if(password.getText() == "")
                Must2.setVisible(true);
            else Must2.setVisible(false);
            if(email.getText() == "")
                Must3.setVisible(true);
            else Must3.setVisible(false);
            if(BirthDate.getValue() == null)
                Must4.setVisible(true);
            else Must4.setVisible(false);
            if(PassportNo.getText() == "")
                Must5.setVisible(true);
            else Must5.setVisible(false);
        }
        else {
            Statement st = ConnectDB.getConnection();
            try {
                String passwd = password.getText();
                String bcryptHashString = BCrypt.hashpw(passwd, BCrypt.gensalt());
                System.out.println(bcryptHashString.length());
                String sql = "INSERT INTO `Passenger` (passenger_first_name, " +
                        "passenger_last_name,passenger_dateOfBirth,passenger_email," +
                        "passenger_gender,passenger_password,passenger_passport_number,"+
                        "passenger_Balance,passenger_Residence,createdAt,updatedAt)" +
                        " VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                String[] Name = FullName.getText().split(" ");
                Random n = new Random(1000);
                PreparedStatement p = st.getConnection().prepareStatement(sql);
                p.setString(1, Name[0]);
                p.setString(2, Name.length > 1 ? Name[1] : " ");
                p.setDate(3, Date.valueOf(BirthDate.getValue()));
                p.setString(4, email.getText());
                p.setString(5, Gender.getText());
                p.setString(6, bcryptHashString);
                p.setString(7, PassportNo.getText());
                p.setInt(8, (int)(2980.0+n.nextDouble(700)));
                p.setString(9, " ");
                p.setDate(10, Date.valueOf(LocalDate.now()));
                p.setDate(11, Date.valueOf(LocalDate.now()));

                p.execute();

                Approved.setVisible(true);
                Approved.setDisable(false);
                backL.setVisible(true);
                backL.setDisable(false);
                backL.setVisible(true);
                backL.setDisable(false);

                List<Node> Off = new ArrayList<Node>();
                Off.add(box1);
                Off.add(box2);
                Off.add(box3);
                Off.add(box4);
                Off.add(box5);
                Off.add(box6);
                Off.add(Signup_lbl);
                Off.add(SignUp);
                Off.add(BirthDate);
                Off.add(FullName);
                Off.add(PassportNo);
                Off.add(password);
                Off.add(email);
                Off.add(Gender);
                Off.add(Back);

                for (Node k :
                        Off) {
                    k.setVisible(false);
                }
                FadeTransition fd = new FadeTransition(Duration.millis(1000), Approved);
                fd.setFromValue(0);
                fd.setToValue(1);
                fd.playFromStart();
                FadeTransition ad = new FadeTransition(Duration.millis(1000), backL);
                ad.setFromValue(0);
                ad.setToValue(1);
                ad.playFromStart();
                FadeTransition we = new FadeTransition(Duration.millis(1000), Approved);
                we.setFromValue(0);
                we.setToValue(1);
                we.playFromStart();


            } catch (SQLException e) {
                System.out.println("DataBaseError");
            } finally {
                ConnectDB.Dispose();
            }
        }

    }

    public void switchPage(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Gender.getItems().addAll("M", "F");
    }
}