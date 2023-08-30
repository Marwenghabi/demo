package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

public interface UserService {
//	String addUser(UserDto userDto);
//
//	LoginResponse loginUser(LoginDto loginDto);

	List<User> getAllUsers();
	 String addUser(UserDto userDto);
}