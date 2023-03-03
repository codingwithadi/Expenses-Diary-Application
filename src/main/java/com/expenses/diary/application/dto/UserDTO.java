package com.expenses.diary.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

	private int userId;
	
	@NotEmpty
	@Size(min=4, message="Please write full and correct name. must be atleast more than 4 character!!")
	private String userName;
	
	@NotEmpty
	@Email(message="must be a well-formed email address -> i.e -> codingwithadi@gmail.com")
	private String userEmail;
	
	@NotEmpty
	@Size(min =10, max =10, message = "Incorrect Mobile Number!!")
	private String userMobileNumber;
}
