package com.washim.flightbooking3rdparty.flightinfo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "flight_info")
@Data
@ToString
public class FlightInfoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotEmpty(message = "Please give flightNo")
    @Column(name = "flight_no")
    private String flightNo;
    @NotEmpty(message = "Please give airlineName")
    @Column(name = "airline_name")
    private String airlineName;
    @NotEmpty(message = "Please give sourceCity")
    @Column(name = "src_city")
    private String sourceCity;
    @NotEmpty(message = "Please give departureTime")
    @Column(name = "dep_time")
    private String departureTime;
    @NotEmpty(message = "Please give destinationCity")
    @Column(name = "dest_city")
    private String destinationCity;
    @NotEmpty(message = "Please give arrivalTime")
    @Column(name = "arr_time")
    private String arrivalTime;
    @NotEmpty(message = "Please give price")
    @Column(name = "price")
    private String price;
}
