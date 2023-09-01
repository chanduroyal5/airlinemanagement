package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.airline.entity.AirLineInformation;

public interface AirLineRepository  extends JpaRepository<AirLineInformation, Integer>{

	@Query("DELETE FROM AirLineInformation a1 where a1.airLineId = : id")
	AirLineInformation deleteAirLineById(@Param("id") int id);
	
	@Query("UPDATE AirLineInformation a1 SET a1.airLineName = :name WHERE a1.airLineId = :id")
	AirLineInformation changeNameById(@Param("id") int id, @Param("name") String name);
}
