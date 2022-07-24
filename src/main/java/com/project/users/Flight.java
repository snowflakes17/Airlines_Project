package com.project.users;

public class Flight {
    private String flightNumber;
    private String airPlaneModel;
    private int flightCapacity;
    private double flightPrice;
    private String flightFrom;
    private String flightTo;

    public void setFlightCapacity(int n){
        this.flightCapacity = n;
    }
    public void setFlightPrice(double n){
        this.flightPrice = n;
    }
    public void setFlightNumber(String n){
        this.flightNumber = n;
    }
    public void setFlightFrom(String n){
        this.flightFrom = n;
    }
    public void setFlightTo(String n){
        this.flightTo = n;
    }
    public void setAirPlaneModel(String n){
        this.airPlaneModel = n;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirPlaneModel() {
        return airPlaneModel;
    }

    public int getFlightCapacity() {
        return flightCapacity;
    }

    public double getFlightPrice() {
        return flightPrice;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }
}
