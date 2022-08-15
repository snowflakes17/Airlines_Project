package com.project.models;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
@Data
public class Customer implements User {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private final Date dateOfBirth;
    private Double Balance;
    private String gender;
    private String countryOfResidence;
    private final Date createdAt;
    private Date updatedAt;
    private String passportNumber;
    private ArrayList Flights;

    public Customer(ResultSet DataSet) throws SQLException {
        this.userId = DataSet.getInt("passenger_id");
        this.firstName = DataSet.getString("passenger_first_name");
        this.email = DataSet.getString("passenger_email");
        this.lastName = DataSet.getString("passenger_last_name");
        this.password = DataSet.getString("passenger_password");
        this.dateOfBirth = DataSet.getDate("passenger_dateOfBirth");
        this.Balance = DataSet.getDouble("passenger_Balance");
        this.countryOfResidence = DataSet.getString("passenger_Residence");
        this.passportNumber = DataSet.getString("passenger_passport_number");
        this.gender = DataSet.getString("passenger_gender");
        this.createdAt = DataSet.getDate("createdAt");
        this.updatedAt = DataSet.getDate("updatedAt");
    }
    public Customer(){
        this.userId = 0;
        this.firstName = null;
        this.email = null;
        this.lastName = null;
        this.password = null;
        this.dateOfBirth = null;
        this.Balance = 0.0;
        this.countryOfResidence = null;
        this.passportNumber = null;
        this.gender = null;
        this.createdAt = null;
        this.updatedAt = null;
    }
    @Override
    public void logout(){
        System.out.println("Logout");
    }
    @Override
    public void findFlight(){
        System.out.println("FindFlight");
    }
    @Override
    public void bookFlight(){
        System.out.println("Book");
    }
    @Override
    public void pay(){
        System.out.println("pay");
    }
    @Override
    public void cancelFlight() {
        System.out.println("Cancel");
    }
    @Override
    public void changeUsername(String newUsername){
        this.firstName = newUsername;
    }
    @Override
    public void changePass(String newPass) {
        this.password = newPass;
    }

    @Override
    public void showTrips() {
        System.out.println("Show");
    }
    @Override
    public boolean isAdmin() {
        return false;
    }

}
