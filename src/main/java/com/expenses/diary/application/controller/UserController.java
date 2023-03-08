package com.expenses.diary.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.diary.application.dto.UserDTO;
import com.expenses.diary.application.service.UserServices;
import com.expenses.diary.application.utility.APIResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserServices userServices;

	// POST
	@PostMapping("/createUser")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
		UserDTO createdUser = this.userServices.createUser(userDTO);
		return new ResponseEntity<UserDTO>(createdUser, HttpStatus.CREATED);
	}

	// PUT / UPDATE
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,
			@PathVariable("userId") Integer userId) {
		UserDTO updatedUser = this.userServices.updateUser(userDTO, userId);
		return new ResponseEntity<UserDTO>(updatedUser, HttpStatus.OK);
	}

	// GET
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDTO>> getAllUser() {
		List<UserDTO> gotAll = this.userServices.getAllUser();
		return new ResponseEntity<List<UserDTO>>(gotAll, HttpStatus.OK);
	}

	// GET by ID
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Integer userId) {
		UserDTO gotById = this.userServices.getUserById(userId);
		return new ResponseEntity<UserDTO>(gotById, HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/deleteAllUsers")
	public ResponseEntity<APIResponse> deleteAllUsers() {
		this.userServices.deleteAllUser();
		return new ResponseEntity<APIResponse>(new APIResponse("All Users Deleted Successfully!!", true),
				HttpStatus.OK);
	}

	// DELETE by ID
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<APIResponse> deleteUserById(@PathVariable("userId") Integer userId) {
		this.userServices.deleteUserById(userId);
		return new ResponseEntity<APIResponse>(new APIResponse("User Deleted Successfully!!", true), HttpStatus.OK);
	}

}
