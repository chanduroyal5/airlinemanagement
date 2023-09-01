package com.jsp.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsp.airline.dto.AirLineInformationDTO;
import com.jsp.airline.dto.FlightDTO;
import com.jsp.airline.entity.AirLineInformation;
import com.jsp.airline.entity.Fare;
import com.jsp.airline.entity.Flight;
import com.jsp.airline.entity.FlightInfo;
import com.jsp.airline.entity.Inventory;
import com.jsp.airline.repository.AirLineRepository;
import com.jsp.airline.repository.FlightRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private AirLineRepository airLineRepository;
	
	
	@Override
	public int addFlight(FlightDTO dto) {
		Flight flight = flightRepository.save(Flight.builder()
													.flightNo(dto.getFlightNo())
													.flightDate(dto.getFlightDate())
													.flightTime(dto.getFlightTime())
													.currentLocation(dto.getCurrentLocation())
													.destination(dto.getDestination())
													.fare(Fare.builder()
																.amount(dto.getFare().getAmount())
																.currency(dto.getFare().getCurrency())
																.build())
													.flightInfo(FlightInfo.builder()
																			.flightNo(dto.getFlightInfo().getFlightNo())
																			.flightType(dto.getFlightInfo().getFlightType())
																			.airLineInfo(AirLineInformation.builder()
																											//.airLineName(dto.getFlightInfo().getAirLineInfo().getAirLineName())
																											.build())
																			.build())
													.inventory(Inventory.builder()
																		.count(dto.getInventory().getCount())
																		.build())
													.build());
		
		
		return flight.getFlightId();
	}
	
	public int addAirLineInformation(AirLineInformationDTO dto) {
		
//		List<FlightInfoDTO> flightsDTO = dto.getFlightInfo();
//		List<FlightInfo> flights = flightsDTO.stream().map(x -> FlightInfo.builder()
//																	.flightNo(x.getFlightNo())
//																	.flightType(x.getFlightType())
//																	.build())
//														.collect(Collectors.toList());
		AirLineInformation airLine = AirLineInformation.builder()
														.airLineName(dto.getAirLineName())
														//.flightInfo(flights)
														.build();
		
		return airLineRepository.save(airLine).getAirLineId();
	}

	@Override
	public void removeAirLine(int id) {
		airLineRepository.deleteById(id);
	}

	@Override
	public String changeAirLineNameNyId(int id, String name) {
		try {
		AirLineInformation airLineInformation = airLineRepository.findById(id).get();
		airLineInformation.setAirLineName(name);
		AirLineInformation save = airLineRepository.save(airLineInformation);
		return save.getAirLineName();
		}
		catch (Exception e) {
			return null;
		}
	}

	
	

	

}
