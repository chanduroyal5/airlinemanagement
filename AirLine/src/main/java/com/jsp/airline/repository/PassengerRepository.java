package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airline.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
