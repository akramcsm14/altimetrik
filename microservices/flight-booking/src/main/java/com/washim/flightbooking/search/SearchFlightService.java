package com.washim.flightbooking.search;

import java.util.List;

public interface SearchFlightService<S, R> {
    List<R> getSearchResults(S s);
    void sort(List<R> rList, String sortField);
}
