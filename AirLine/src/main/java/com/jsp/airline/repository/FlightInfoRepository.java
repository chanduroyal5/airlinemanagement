package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.airline.entity.FlightInfo;

public interface FlightInfoRepository extends JpaRepository<FlightInfo, Integer> {

	@Query("DELETE FROM FlightInfo f1 WHERE f1.airLineInfo.airLineId = :id")
	FlightInfo removeFlightsbyAirLineId(@Param("id") int id);
}
