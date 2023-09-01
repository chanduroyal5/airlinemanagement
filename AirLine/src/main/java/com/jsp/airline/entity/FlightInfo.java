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
public class FlightInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightInfoId;
	private int flightNo;
	private String flightType;
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy = "flightInfo")
	private Flight flight;
	
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "airline_id")
	private AirLineInformation airLineInfo;
}
