package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airline.entity.BookingInformation;

public interface BookingInfoRepository extends JpaRepository<BookingInformation, Integer> {

}
