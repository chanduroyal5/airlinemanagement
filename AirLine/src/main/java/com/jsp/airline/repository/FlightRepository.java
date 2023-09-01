package com.jsp.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.airline.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	
	@Query("SELECT f1 FROM Flight f1 WHERE f1.currentLocation = :current AND f1.destination = :destination AND f1.flightDate = :date")
	Flight searchFlight(@Param("current") String currentLocation ,@Param("destination") String destination ,@Param("date") String date );
	
	
	@Query("SELECT f1 "
		+ "FROM Flight f1, AirLineInformation a1 "
		+ "WHERE f1.flightNo = :no AND f1.flightDate = :date AND f1.flightTime = :time AND a1.airLineName = :airlineName")
	Flight findFlight(@Param("airlineName") String airLineName ,@Param("no")  int flightNo ,@Param("date")  String date ,@Param("time")  String flightTime);
	
	/*
	 * 	SELECT f1.*,a1.*
		FROM flight f1,flight_info f2,airline_info a1
		WHERE f1.flight_no = 18987 AND f1.flight_date = '2023-08-20' AND f1.flight_time = '09:45:00' AND a1.air_line_name = 'AIR India' 
	 */
	
	
	@Query("SELECT f1 FROM Flight f1 WHERE f1.flightNo = :no AND f1.flightDate = :date AND f1.flightTime = :time")
	List<Flight> searchFlightByAssendingOrder(@Param("no") Integer flightNo ,@Param("date") String date ,@Param("time") String time );
	
}
