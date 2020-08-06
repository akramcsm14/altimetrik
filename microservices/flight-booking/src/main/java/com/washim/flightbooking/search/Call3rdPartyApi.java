package com.washim.flightbooking.search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class Call3rdPartyApi {

    public List<FlightInfoDTO> getFlightResults(FlightSearchDO flightSearchDO) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8088/getSearchResults/";

        //adding the query params to the URL
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("sourceCity", flightSearchDO.getSourceCity())
                .queryParam("destinationCity", flightSearchDO.getDestinationCity())
                .queryParam("travelDate", flightSearchDO.getTravelDate())
                .queryParam("returnDate", flightSearchDO.getReturnDate());
        HttpHeaders requestHeaders = new HttpHeaders();
        //set up HTTP Basic Authentication Header
//        requestHeaders.add("Authorization", authorizationHeader);
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        //request entity is created with request headers
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        ResponseEntity<FlightInfoDTO[]> response = restTemplate.exchange(uriBuilder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                FlightInfoDTO[].class);
        return Arrays.asList(response.getBody());
    }
}
