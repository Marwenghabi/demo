package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v2/user")
@CrossOrigin(origins = "http://localhost:3000/", exposedHeaders = "Authorization")
@Api(value = "Users" , description =" api user ")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	@ApiOperation(value = "Register a new user, Registers a new user in the system.", response = User.class)
	public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
		String result = userService.addUser(userDto);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/hello")
	@ApiOperation(value = "Test endpoint, A simple test endpoint that returns a greeting.", response = User.class)
	public String hello() {
		return "Hello, World!";
	}

//	@PostMapping("/send")
//	public ResponseEntity<String> sendSmsToTelecomCtt(@RequestBody SmsRequest smsRequest) {
//	    
//	    List<Sms> telecomCttNumbers = smsRepository.findByOperator("telecomctt");
//
//	    if (telecomCttNumbers.isEmpty()) {
//	        return ResponseEntity.ok("Aucun numéro Telecom CTT trouvé dans la base de données.");
//	    }
//
//	   
//	    for (Sms sms : telecomCttNumbers) {
//	      
//	    }
//
//	    return ResponseEntity.ok("SMS envoyé avec succès à tous les numéros Telecom CTT.");
//	}
	
	// Other user-related endpoints can be added here
}
