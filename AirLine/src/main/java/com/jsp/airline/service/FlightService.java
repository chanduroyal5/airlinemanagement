package com.jsp.airline.service;

import java.util.List;

import com.jsp.airline.dto.FlightDTO;

public interface FlightService {

	FlightDTO searchFlight(String currentLocation , String destination , String date);
	FlightDTO searchFlightByAirLineName(String airLineName ,int flightNo ,String date , String flightTime);
	
	
	List<FlightDTO> searchFlightByAscendingOrder(Integer flightNo , String date , String time);
	
	List<FlightDTO> getAllFlights();
}
