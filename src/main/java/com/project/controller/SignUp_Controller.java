package com.project.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SignUp_Controller {

    @FXML
    private MFXButton Back;

    @FXML
    private MFXDatePicker BirthDate;

    @FXML
    private MFXTextField FullName;

    @FXML
    private MFXTextField PassportNo;

    @FXML
    private MFXButton SignUp;

    @FXML
    private MFXTextField email;

    @FXML
    private MFXPasswordField password;

    @FXML
    void SignUp(ActionEvent event) {
        System.out.println("Check");
    }

    @FXML
    void backToLogin(ActionEvent event) {

    }

}