package com.washim.flightbooking3rdparty.flightinfo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class FlightInfo {
    @Autowired
    private FlightInfoService<FlightSearchDO, FlightInfoDTO> flightInfoService;
    @Autowired
    private FlightInfoRepository flightInfoRepo;

    /**
     * Get the flight info by flight departure and arrival date
     *
     * @param sourceCity
     * @param destinationCity
     * @param travelDate
     * @param returnDate
     * @return
     */
    @GetMapping(value = "/getSearchResults", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlightInfoDTO> getSearchResults(@RequestParam String sourceCity, @RequestParam String destinationCity,
                                                @RequestParam String travelDate, @RequestParam String returnDate) {
        log.info("/getSearchResults called");
        FlightSearchDO flightSearchDO = new FlightSearchDO(sourceCity, destinationCity, travelDate, returnDate);
        return flightInfoService.getResults(flightSearchDO);
    }

    /**
     * Add Flight Info
     *
     * @param flightInfoDTO
     * @return
     */
    @PostMapping(value = "/addFlightInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public FlightInfoDTO addFlightInfo(@RequestBody @Valid FlightInfoDTO flightInfoDTO) {
        log.info("/getSearchResults called");
        return flightInfoRepo.save(flightInfoDTO);
    }
}
