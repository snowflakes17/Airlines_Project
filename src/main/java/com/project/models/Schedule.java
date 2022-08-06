package com.project.models;

import lombok.Data;
import java.util.Date;

@Data
public class Schedule {
    private Date flightDay;
    private Date departureTime;
    private Date arrivalTime;
    private Flight flight;
}
