package com.jsp.airline.dto;

import java.util.List;

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
public class AirLineInformationDTO {

	private int airLineId;
	private String airLineName;
	
	private List<FlightInfoDTO> flightInfo;
}
