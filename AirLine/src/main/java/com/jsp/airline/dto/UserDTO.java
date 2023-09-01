package com.jsp.airline.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {

	private String firstName;
	private String lastName;
	private String mobileNo;
	private String Gender;
	private String userName;
	private String password;
}
