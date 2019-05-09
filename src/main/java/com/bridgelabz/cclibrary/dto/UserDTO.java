package com.bridgelabz.cclibrary.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDTO {
	
	@NotEmpty(message="Please enter valid full name")
	private String fullName;
	
	@NotEmpty(message="Please enter valid Email Id")
	private String emailId;
	
	private String gender;
	
	@Size(min=10, max=10, message="Please enter valid phone number")
	@Pattern(regexp="(^$|[0-9]{10})", message="Please enter valid phone number")
	private String phoneNumber;
	
	private String role;
	
	@NotEmpty(message="Please enter valid campaign Id")
	private String cId;
}