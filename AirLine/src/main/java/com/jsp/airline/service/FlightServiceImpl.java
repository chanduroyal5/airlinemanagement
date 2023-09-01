package com.jsp.airline.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.airline.dto.FareDTO;
import com.jsp.airline.dto.FlightDTO;
import com.jsp.airline.entity.Flight;
import com.jsp.airline.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public FlightDTO searchFlight(String currentLocation, String destination, String date) {
		Flight flight = flightRepository.searchFlight(currentLocation, destination, date);
		if(flight != null) {
			return FlightDTO.builder()
							.currentLocation(currentLocation)
							.destination(destination)
							.flightDate(date)
							.build();
		}else {
			return null;
		}
	}

	@Override
	public FlightDTO searchFlightByAirLineName(String airLineName, int flightNo, String date, String flightTime) {
		Flight flight = flightRepository.findFlight(airLineName, flightNo, date, flightTime);
		if(flight != null) {
			return FlightDTO.builder()
							.flightNo(flightNo)
							.flightTime(flightTime)
							.flightDate(date)
							.build();
		}else {
			return null;
		}
	}

	@Override
	public List<FlightDTO> searchFlightByAscendingOrder(Integer flightNo, String date, String time) {
		List<Flight> list = flightRepository.searchFlightByAssendingOrder(flightNo, date, time);
		if(list != null) {
			List<FlightDTO> finalFlights = list.stream()
												.map(x -> FlightDTO.builder()
																	.flightNo(flightNo)
																	.flightDate(date)
																	.flightTime(time)
																	.fare(FareDTO.builder()
																				.amount(x.getFare().getAmount())
																				.build())
																	.build())
												.collect(Collectors.toList());
			return finalFlights;
			
		}else {
			return null;
		}
	}

	@Override
	public List<FlightDTO> getAllFlights() {
		return flightRepository.findAll().stream()
											.map(flight -> FlightDTO.builder()
																	.currentLocation(flight.getCurrentLocation())
																	.destination(flight.getDestination())
																	.flightDate(flight.getFlightDate())
																	.flightTime(flight.getFlightTime())
																	.flightNo(flight.getFlightNo())
																	.build())
											.collect(Collectors.toList());
	}

	
}
