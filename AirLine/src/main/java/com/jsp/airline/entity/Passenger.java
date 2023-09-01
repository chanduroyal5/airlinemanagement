package com.jsp.airline.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int passengerId;
	private String passengerName;
	private String email;
	private String Gender;
	private String mobileNo;
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER )
	@JoinColumn(name = "booking_id")
	private BookingInformation bookingInformation;
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER )
	@JoinColumn(name = "checkIn_id")
	private CheckIn checkIn;
}
