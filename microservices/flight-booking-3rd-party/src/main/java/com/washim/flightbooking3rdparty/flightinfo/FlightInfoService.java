package com.washim.flightbooking3rdparty.flightinfo;

import java.util.List;

public interface FlightInfoService<S, R> {
    List<R> getResults(S s);
}
