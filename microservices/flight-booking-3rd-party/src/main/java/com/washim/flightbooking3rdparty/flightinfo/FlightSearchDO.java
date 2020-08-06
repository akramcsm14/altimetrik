package com.washim.flightbooking3rdparty.flightinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@ToString
public class FlightSearchDO {
    @NotEmpty(message = "Source City can not be empty")
    private String sourceCity;
    @NotEmpty(message = "Destination City can not be empty")
    private String destinationCity;
    @NotEmpty(message = "Travel Date can not be empty")
    private String travelDate;
    private String returnDate;
}
