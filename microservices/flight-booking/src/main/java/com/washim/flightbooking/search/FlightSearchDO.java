package com.washim.flightbooking.search;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class FlightSearchDO {
    @NotEmpty(message = "Source City can not be empty")
    private String sourceCity;
    @NotEmpty(message = "Destination City can not be empty")
    private String destinationCity;
    @NotEmpty(message = "Travel Date can not be empty")
    private String travelDate;
    private String returnDate;
}
