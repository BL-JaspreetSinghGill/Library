package com.bridgelabz.cclibrary.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RegisterOnlyUserDTO {
	
//	@NotEmpty(message="Please enter valid campaign Id")
	private String campaignId;
	
	@NotEmpty(message="Please enter valid Email Id")
	private String emailId;
	
	private String gender;
	
	@NotEmpty(message="Please enter valid full name")
	private String fullName;
	
	@Size(min=10, max=10, message="Please enter valid phone number")
	@Pattern(regexp="(^$|[0-9]{10})", message="Please enter valid phone number")
	private String phoneNumber;

	@Size(min=6, max=6, message="Please enter a 6 digit valid pin code")
	private String permanentPinCode;
	
	@Size(min=6, max=6, message="Please enter a 6 digit valid pin code")
	private String currentPinCode;
	
	@NotEmpty(message="Please enter valid qualification")
	private String qualification;
	
	@Size(min=4, max=4, message="Please select valid graduation year")
	@Pattern(regexp="(^$|[0-9]{4})", message="Please select valid graduation year")
	private String graduationYear;
		
	private String referralName;
	
	private String referralContactNumber;
	
	private String role;
}