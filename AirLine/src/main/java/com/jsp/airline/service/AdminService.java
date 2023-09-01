package com.jsp.airline.service;

import com.jsp.airline.dto.AirLineInformationDTO;
import com.jsp.airline.dto.FlightDTO;

public interface AdminService {

	int addFlight(FlightDTO dto);
	int addAirLineInformation(AirLineInformationDTO dto);
	
	void removeAirLine(int id);
	String changeAirLineNameNyId(int id, String name);
}
