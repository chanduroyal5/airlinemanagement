package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airline.entity.CheckIn;

public interface CheckInRepository extends JpaRepository<CheckIn, Integer> {

}
