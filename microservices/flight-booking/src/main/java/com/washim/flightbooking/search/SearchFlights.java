package com.washim.flightbooking.search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class SearchFlights {

    @Autowired
    private SearchFlightService<FlightSearchDO, FlightInfoDTO> searchFlightService;

    /**
     *
     * @param flightSearchDO
     * @return
     */
    @GetMapping(value = "/findFlights", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlightInfoDTO> findFlight(@RequestBody @Valid FlightSearchDO flightSearchDO) {
        log.info("/findFlight called");
        return searchFlightService.getSearchResults(flightSearchDO);
    }

    /**
     *
     * @param flightInfoDTOS
     * @param sortField
     * @return
     */
    @GetMapping(value = "/sortFlights", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlightInfoDTO> sortFlights(@RequestBody FlightInfoDTO[] flightInfoDTOS, @RequestHeader String sortField) {
        log.info("/sortFlights called");
        List<FlightInfoDTO> flightInfoDTOList = Arrays.asList(flightInfoDTOS);
        searchFlightService.sort(flightInfoDTOList, sortField);
        return flightInfoDTOList;
    }
}
