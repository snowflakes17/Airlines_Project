package com.project.models;
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

    public Flight(ResultSet DataSet) throws SQLException {
        this.flightNumber = DataSet.getInt("flight_number");
        this.flightPrice = DataSet.getDouble("flight_price");
        this.AirlineId = DataSet.getString("airline_id");
        this.flightEndTime = DataSet.getDate("flight_end_time");
        this.flightStartTime = DataSet.getDate("flight_start_time");
        this.flightTo = DataSet.getString("flight_to");
        this.flightFrom = DataSet.getString("flight_from");
    }
}
