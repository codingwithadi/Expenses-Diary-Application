package com.expenses.diary.application.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.diary.application.dto.UserDTO;
import com.expenses.diary.application.entities.User;
import com.expenses.diary.application.exceptions.ResourceNotFoundException;
import com.expenses.diary.application.repo.UserRepo;
import com.expenses.diary.application.service.UserServices;

@Service
public class UserServiceImpl implements UserServices{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = this.modelMapper.map(userDTO, User.class);
		User saveUser = this.userRepo.save(user);
		UserDTO savedUser  = this.modelMapper.map(saveUser, UserDTO.class);
		return savedUser;
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "ID", userId));
		
		user.setUserName(userDTO.getUserName());
		user.setUserEmail(userDTO.getUserEmail());
		user.setUserMobileNumber(userDTO.getUserMobileNumber());
		
		User udateUser = this.userRepo.save(user);
		
		UserDTO updatedUser = this.modelMapper.map(udateUser, UserDTO.class);
		
		return updatedUser;
	}

	@Override
	public List<UserDTO> getAllUser() {
		List<User> allUsers  = this.userRepo.findAll();
		List<UserDTO> allUsersDto = allUsers.stream().map((eUser)-> this.modelMapper.map(eUser, UserDTO.class)).collect(Collectors.toList());
		return allUsersDto;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "ID", userId));
		UserDTO userDto = this.modelMapper.map(user, UserDTO.class);
		return userDto;
	}

	@Override
	public void deleteUserById(Integer userId) {
		User user  = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "ID", userId));
		this.userRepo.delete(user);
	}

	@Override
	public void deleteAllUser() {
		this.userRepo.deleteAll();
		
	}

}
