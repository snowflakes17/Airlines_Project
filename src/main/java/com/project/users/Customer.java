package com.project.users;

import java.text.DateFormat;
import java.util.Date;

public class Customer implements User {
    private int userId;
    private String firstName;
    private String lastName;
    private DateFormat dateOfBirth;
    private String countryOfCitiznship;
    private String countryOfResidence;
    private DateFormat createdAt;
    private DateFormat updatedAt;
    private String passportNumber;

    public Customer(int userId, String firstName, String lastName, DateFormat dateOfBirth,String countryOfCitiznship, String countryOfResidence,String passportNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.countryOfCitiznship = countryOfCitiznship;
        this.countryOfResidence = countryOfResidence;
        this.passportNumber = passportNumber;
        createdAt = DateFormat.getDateTimeInstance();
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
        System.out.println("newUsername");
    }

    @Override
    public void changePass(String newPass) {
        System.out.println("newPass");
    }

    @Override
    public void showTrips() {
        System.out.println("Show");
    }

    @Override
    public int getUserid() {
        return userId;
    }

    @Override
    public String getFullname() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean isAdmin() {
        return false;
    }

}
