package com.expenses.diary.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

	private int userId;
	private String userName;
	private String userEmail;
	private String userMobileNumber;
}
