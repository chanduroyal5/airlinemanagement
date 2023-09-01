package com.jsp.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.airline.dto.BookingDTO;
import com.jsp.airline.dto.CheckInDTO;
import com.jsp.airline.dto.PassengerDTO;
import com.jsp.airline.dto.UserDTO;
import com.jsp.airline.entity.BookingInformation;
import com.jsp.airline.entity.CheckIn;
import com.jsp.airline.entity.Passenger;
import com.jsp.airline.entity.User;
import com.jsp.airline.repository.BookingInfoRepository;
import com.jsp.airline.repository.CheckInRepository;
import com.jsp.airline.repository.PassengerRepository;
import com.jsp.airline.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private BookingInfoRepository bookingInfoRepository;
	
	@Autowired
	private CheckInRepository checkInRepository;
	
	@Override
	public int registerUser(UserDTO dto) {
		return userRepository.save(User.builder()
										.firstName(dto.getFirstName())
										.lastName(dto.getLastName())
										.mobileNo(dto.getMobileNo())
										.Gender(dto.getGender())
										.userName(dto.getUserName())
										.password(dto.getPassword())
										.build())
				 .getId();
	}
	
	public int registerPassenger(PassengerDTO dto) {
		//BookingInformation bookingInformation = bookingInfoRepository.findById( dto.getBooking().getBookingId() ) .get();
		return passengerRepository.save(Passenger.builder()
												.passengerName(dto.getPassengerName())
												.email(dto.getEmail())
												.Gender(dto.getGender())
												.mobileNo(dto.getMobileNo())
												.bookingInformation(BookingInformation.builder()
																						.bookingDate(dto.getBooking().getBookingDate())
																						.destination(dto.getBooking().getDestination())
																						.fare(dto.getBooking().getFare())
																						.flightNo(dto.getBooking().getFlightNo())
																						.flightTime(dto.getBooking().getFlightTime())
																						.status(dto.getBooking().getStatus())
																						.currentCity(dto.getBooking().getCurrentCity())
																						.build())
												.checkIn(CheckIn.builder()
																.gateNo(dto.getCheckIn().getGateNo())
																.seatNo(dto.getCheckIn().getSeatNo())
																.build())
												.build()).getPassengerId();
	}

	@Override
	public int booking(BookingDTO dto) {
		return bookingInfoRepository.save(BookingInformation.builder()
															.bookingDate(dto.getBookingDate())
															.destination(dto.getDestination())
															.fare(dto.getFare())
															.flightDate(dto.getFlightDate())
															.flightNo(dto.getFlightNo())
															.flightTime(dto.getFlightTime())
															.status(dto.getStatus())
															.currentCity(dto.getCurrentCity())
															.build())
						.getBookingId();
	}

	@Override
	public int checkIn(CheckInDTO dto) {
		return checkInRepository.save(CheckIn.builder()
											.gateNo(dto.getGateNo())
											.seatNo(dto.getSeatNo())
											.build())
					.getCheckInId();
	}

	@Override
	public UserDTO userLogIn(String userName, String password) {
		User user = userRepository.logInUser(userName, password);
		if(user != null) {
			return UserDTO.builder()
							.firstName(user.getFirstName())
							.lastName(user.getLastName())
							.build();
		}
		else {
			return null;
		}
	}
	
	
	
}
