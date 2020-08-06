package com.washim.flightbooking3rdparty.flightinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightInfoRepository extends JpaRepository<FlightInfoDTO, Integer> {
    @Query(value = "select c.id ,c.flight_no ,c.airline_name, c.src_city ,c.dep_time, c.dest_city, c.arr_time, c.price from flight_info c " +
            "where c.dep_time like concat(:departureTime, '%')", nativeQuery = true)
    List<FlightInfoDTO> findByDepartureTime(String departureTime);
}
