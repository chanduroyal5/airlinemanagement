package com.jsp.airline.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class CheckIn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int checkInId;
	private String seatNo;
	private String gateNo;
	
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy = "checkIn")
	private Passenger passenger;
	
}
