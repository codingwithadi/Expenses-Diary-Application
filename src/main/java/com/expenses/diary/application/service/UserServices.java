package com.expenses.diary.application.service;

import java.util.List;

import com.expenses.diary.application.dto.UserDTO;

public interface UserServices {
	
	//create
	UserDTO createUser(UserDTO userDTO);
	
	//update
	UserDTO updateUser(UserDTO userDTO, Integer userId);
	
	//get all
	List<UserDTO> getAllUser();
	
	//get by id
	UserDTO getUserById(Integer userId);
	
	//delete by id
	void deleteUserById(Integer userId);
	
	//delete all
	void deleteAllUser();
}
