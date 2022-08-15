package com.project.models;
import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Data
public class Ticket {
    private String ticket_id;
    private int passenger_id;
    private int flight_number;

    private Date purchase_date;
    private String seat_row;

    public Ticket(ResultSet DataSet) throws SQLException {
        this.ticket_id = DataSet.getString("ticket_id");
        this.passenger_id = DataSet.getInt("passenger_id");
        this.purchase_date = DataSet.getDate("purchase_date");
        this.flight_number = DataSet.getInt("flight_number");
        this.seat_row = DataSet.getString("seat_row");
    }

}
