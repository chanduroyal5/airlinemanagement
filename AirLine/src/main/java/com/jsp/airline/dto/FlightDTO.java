package com.jsp.airline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FlightDTO {

	private String destination;
	private String flightDate;
	private int flightNo;
	private String flightTime;
	private String currentLocation;
	
	private FareDTO fare;
	
	private FlightInfoDTO flightInfo;
	
	private InventoryDTO inventory;
}
