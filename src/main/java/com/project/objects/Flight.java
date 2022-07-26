package com.project.objects;
import lombok.*;

@Data
public class Flight {
    private String flightNumber;
    private String airPlaneModel;
    private int flightCapacity;
    private double flightPrice;
    private String flightFrom;
    private String flightTo;
}
