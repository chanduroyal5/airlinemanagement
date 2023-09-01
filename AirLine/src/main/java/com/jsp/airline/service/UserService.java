package com.jsp.airline.service;

import com.jsp.airline.dto.BookingDTO;
import com.jsp.airline.dto.CheckInDTO;
import com.jsp.airline.dto.PassengerDTO;
import com.jsp.airline.dto.UserDTO;

public interface UserService {

	int registerUser(UserDTO dto);
	int registerPassenger(PassengerDTO dto);
	int booking(BookingDTO dto);
	int checkIn(CheckInDTO dto);
	
	UserDTO userLogIn(String userName,String password);
}
