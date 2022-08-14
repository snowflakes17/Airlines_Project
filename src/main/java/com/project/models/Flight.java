package com.project.models;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Data
public class Flight {

    private int flightNumber;
    private String AirlineId;
    private double flightPrice;
    private String flightFrom;
    private String flightTo;
    private Date flightStartTime;
    private Date flightEndTime;
    private RadioButton select;

    public Flight(ResultSet DataSet) throws SQLException {
        this.flightNumber = DataSet.getInt("flight_number");
        this.flightPrice = DataSet.getDouble("flight_price");
        this.AirlineId = DataSet.getString("airline_id");
        this.flightEndTime = DataSet.getDate("flight_end_time");
        this.flightStartTime = DataSet.getDate("flight_start_time");
        this.flightTo = DataSet.getString("flight_to");
        this.flightFrom = DataSet.getString("flight_from");
        this.select = new RadioButton();
    }

    public Flight(){
        this.flightNumber = 0;
        this.flightPrice = 0.0;
        this.AirlineId = " ";
        this.flightEndTime = new Date();
        this.flightStartTime = new Date();
        this.flightTo = " ";
        this.flightFrom = " ";
    }
}
