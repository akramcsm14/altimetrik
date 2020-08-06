package com.washim.flightbooking3rdparty.flightinfo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FlightInfoServiceImpl implements FlightInfoService<FlightSearchDO, FlightInfoDTO> {
    @Autowired
    private FlightInfoRepository flightInfoRepo;

    @Override
    public List<FlightInfoDTO> getResults(FlightSearchDO flightSearchDO) {
        log.info("get flight results service");
        List<FlightInfoDTO> result;
        List<FlightInfoDTO> returnResult;
        List<FlightInfoDTO> finalResult;
        result = flightInfoRepo.findByDepartureTime(flightSearchDO.getTravelDate());
        if (!flightSearchDO.getReturnDate().equals("")) {
            returnResult = flightInfoRepo.findByDepartureTime(flightSearchDO.getReturnDate());
            result.addAll(returnResult);
        }
        return result;
    }
}
