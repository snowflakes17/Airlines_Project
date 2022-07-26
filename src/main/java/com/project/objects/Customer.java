package com.project.objects;

import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
@Data
public class Customer implements User {
    private final int userId;
    private String firstName;
    private String lastName;
    private String password;
    private final Date dateOfBirth;
    private String countryOfCitiznship;
    private String countryOfResidence;
    private final LocalTime createdAt;
    private LocalTime updatedAt;
    private final String passportNumber;
    private ArrayList Flights;

    public Customer(int userId, String password, String firstName, String lastName, Date dateOfBirth, String countryOfCitiznship, String countryOfResidence, String passportNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.countryOfCitiznship = countryOfCitiznship;
        this.countryOfResidence = countryOfResidence;
        this.passportNumber = passportNumber;
        createdAt = LocalTime.now();
        updatedAt = createdAt;
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
