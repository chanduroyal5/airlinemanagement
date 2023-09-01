package com.jsp.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airline.dto.FlightDTO;
import com.jsp.airline.service.FlightService;

@RestController
@RequestMapping("/flightapi")
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	
	@GetMapping("/searchflight/{loc}/{des}/{date}")
	public ResponseEntity<FlightDTO> searchFlight(@PathVariable("loc") String currentLocation,@PathVariable("des") String destination,@PathVariable("date") String date) {
		
		FlightDTO dto = flightService.searchFlight(currentLocation, destination, date);
		if(dto != null) {
			return ResponseEntity.ok(dto);
		}else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	
	@GetMapping("/findflight/{airLineName},{flightNo},{date},{flightTime}")
	public ResponseEntity<String> findFlight(@PathVariable("airLineName") String airLineName,@PathVariable("flightNo") int flightNo,@PathVariable("date") String date,@PathVariable("flightTime") String flightTime){
		FlightDTO dto = flightService.searchFlightByAirLineName(airLineName, flightNo, date, flightTime);
		if(dto != null) {
			return ResponseEntity.accepted().body("Flight No : "+dto.getFlightNo());
		}else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@GetMapping("/findflight/ascending/{flightNo},{date},{time}")
	public ResponseEntity<List<FlightDTO>> searchFlightByAscendingOrder(Integer flightNo , String date , String time){
		List<FlightDTO> list = flightService.searchFlightByAscendingOrder(flightNo, date, time);
		if(list != null) {
			return ResponseEntity.ok(list);
		}
		return ResponseEntity.badRequest().body(null);
	}
}
