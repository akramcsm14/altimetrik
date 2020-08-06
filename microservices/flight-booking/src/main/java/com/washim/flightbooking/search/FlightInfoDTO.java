package com.washim.flightbooking.search;

import lombok.Data;

import java.io.Serializable;


@Data
public class FlightInfoDTO implements Serializable {
    private int id;
    private String flightNo;
    private String airlineName;
    private String sourceCity;
    private String departureTime;
    private String destinationCity;
    private String arrivalTime;
    private String price;
}
