package com.jsp.airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airline.dto.AirLineInformationDTO;
import com.jsp.airline.dto.FlightDTO;
import com.jsp.airline.service.AdminService;


@RestController
@RequestMapping("/userapi")
public class AdminController {
	
	@Autowired
	
	private AdminService adminService;

	
	@PostMapping("/addairline")
	public ResponseEntity<String> addAirLine(@RequestBody AirLineInformationDTO dto){
		int id = adminService.addAirLineInformation(dto);
		if(id != 0 ) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("AirLine Id : "+id);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PostMapping("/addflight")
	public ResponseEntity<String> addFlight(@RequestBody FlightDTO dto){
		int id = adminService.addFlight(dto);
		if(id != 0 ) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Flight Id : "+id);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@GetMapping("/removeairline/{id}")
	public void removeAirLine(@PathVariable("id") int id){
		adminService.removeAirLine(id);
	}
	
	@PutMapping("/updateairline/{id}/{name}")
	public ResponseEntity<String> updateAirLineNameById(@PathVariable("id") int id, @PathVariable("name") String name){
		String string = adminService.changeAirLineNameNyId(id, name);
		if(string != null)
			return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body("UPDATED DETAILS");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@PostMapping("/newmethod")
	public void newMethod() {
		System.out.println("NEW METHOD ADDED");
	}
}
