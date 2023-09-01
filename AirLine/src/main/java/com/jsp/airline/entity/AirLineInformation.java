package com.jsp.airline.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "airline_info")
public class AirLineInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int airLineId;
	private String airLineName;
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy = "airLineInfo")
	private List<FlightInfo> flightInfo;
}
