package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserDto userDto) {
        // Check if the username or email already exists
        if (userRepository.existsByUsernameOrEmail(userDto.getUsername(), userDto.getEmail())) {
            return "Username or email already exists";
        }

        // Create a new user entity
        User user = new User();
        user.setUsername(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRole());

        userRepository.save(user);

        return "User added successfully";
    }


	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

    // ... (other methods)
}
