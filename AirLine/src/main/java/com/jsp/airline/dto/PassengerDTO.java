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
public class PassengerDTO {

	private String passengerName;
	private String email;
	private String Gender;
	private String mobileNo;
	
	private BookingDTO booking;
	
	private CheckInDTO checkIn;
}
