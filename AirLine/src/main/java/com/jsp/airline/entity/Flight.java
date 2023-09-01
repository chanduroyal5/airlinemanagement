package com.jsp.airline.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightId;
	private String destination;
	private String flightDate;
	private int flightNo;
	
//	@JsonFormat(pattern = "hh:mm")
//	@DateTimeFormat(pattern = "hh:mm")
	private String flightTime;
	
	private String currentLocation;
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "fare_id")
	private Fare fare;
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "flightInfo_id")
	private FlightInfo flightInfo;
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "inventory_id")
	private Inventory inventory;
	
}
