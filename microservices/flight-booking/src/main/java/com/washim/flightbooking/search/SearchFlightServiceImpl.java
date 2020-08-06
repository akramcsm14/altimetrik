package com.washim.flightbooking.search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
public class SearchFlightServiceImpl implements SearchFlightService<FlightSearchDO, FlightInfoDTO> {
    @Autowired
    private Call3rdPartyApi call3rdPartyApi;

    @Override
    public List<FlightInfoDTO> getSearchResults(FlightSearchDO flightSearchDO) {
        log.info("Calling 3rd Part API to get flight search result");
        List<FlightInfoDTO> result = call3rdPartyApi.getFlightResults(flightSearchDO);
        List<FlightInfoDTO> toBeRemoved = new ArrayList<>();
        if (flightSearchDO.getReturnDate() == null) {
            for (FlightInfoDTO flightInfoDTO : result) {
                //Removing unnecessary data from the search result
                if (!(flightInfoDTO.getSourceCity().equals(flightSearchDO.getSourceCity()) &&
                        flightInfoDTO.getDestinationCity().equals(flightSearchDO.getDestinationCity()))) {
                    toBeRemoved.add(flightInfoDTO);
                }
            }
        } else {
            for (FlightInfoDTO flightInfoDTO : result) {
                //Removing the entries which doesn't match the source or destination
                if (!flightInfoDTO.getSourceCity().equals(flightSearchDO.getSourceCity()) &&
                        !flightInfoDTO.getSourceCity().equals(flightSearchDO.getDestinationCity())) {
                    toBeRemoved.add(flightInfoDTO);
                }
            }
        }
        List<FlightInfoDTO> res = new ArrayList<>(result);
        try {
            res.removeAll(toBeRemoved);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    @Override
    public void sort(List<FlightInfoDTO> flightInfoDTOS, String sortField) {
        switch (sortField.toLowerCase()) {
            case "flightno":
                flightInfoDTOS.sort(Comparator.comparing(FlightInfoDTO::getFlightNo));
                break;
            case "airlinename":
                flightInfoDTOS.sort(Comparator.comparing(FlightInfoDTO::getAirlineName));
                break;
            case "sourcecity":
                flightInfoDTOS.sort(Comparator.comparing(FlightInfoDTO::getSourceCity));
                break;
            case "departuretime":
                flightInfoDTOS.sort(Comparator.comparing(FlightInfoDTO::getDepartureTime));
                break;
            case "destinationcity":
                flightInfoDTOS.sort(Comparator.comparing(FlightInfoDTO::getDestinationCity));
                break;
            case "arrivaltime":
                flightInfoDTOS.sort(Comparator.comparing(FlightInfoDTO::getArrivalTime));
                break;
            case "price":
                flightInfoDTOS.sort(Comparator.comparing(FlightInfoDTO::getPrice));
                break;
        }
    }
}
