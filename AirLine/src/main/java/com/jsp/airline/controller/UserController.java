package com.jsp.airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airline.dto.PassengerDTO;
import com.jsp.airline.dto.UserDTO;
import com.jsp.airline.service.UserService;

@RestController
@RequestMapping("/userapi")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/registeruser")
	public ResponseEntity<String> addUser(@RequestBody UserDTO dto){
		int id = userService.registerUser(dto);
		if (id != 0) {
			return ResponseEntity.ok("User Id is : "+id);
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	
	@PostMapping("/addpassenger")
	public ResponseEntity<String> addPassenger(@RequestBody PassengerDTO dto){
		int id = userService.registerPassenger(dto);
		if (id != 0) {
			return ResponseEntity.ok("Passenger Id is : "+id);
		} else {
			return ResponseEntity.badRequest().body("SERVER busy");
		}
	}
	
	@GetMapping("/userlogin/{name}/{password}")
	public ResponseEntity<String> userLogIn(@PathVariable("name") String userName ,@PathVariable("password") String password){
		UserDTO dto = userService.userLogIn(userName, password);
		if (dto != null) {
			return ResponseEntity.accepted().body("LogIn SuccessFull");
		} else {
			return ResponseEntity.badRequest().body("Failed To LogIn");
		}
	}
	
}
