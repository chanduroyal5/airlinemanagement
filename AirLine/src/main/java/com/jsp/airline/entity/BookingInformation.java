package com.jsp.airline.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class BookingInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	private LocalDate bookingDate;
	private String destination;
	private double fare;
	private LocalDate flightDate;
	private int flightNo;
	private String status;
	private LocalTime flightTime;
	private String currentCity;
	
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy = "bookingInformation")
	private List<Passenger> passenger;
	
}
