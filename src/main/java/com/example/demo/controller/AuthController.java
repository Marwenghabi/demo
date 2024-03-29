package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtTokenProvider;
import com.example.demo.dto.JwtAuthenticationResponse;
import com.example.demo.dto.UserDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/auth")
@Api(value = "login" , description =" api login ")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	
	@CrossOrigin(origins = "http://localhost:3000/", exposedHeaders = "Authorization")
	@PostMapping("/login")
	@ApiOperation(value = "login", response = UserDto.class)
	@ApiResponse(responseCode = "200", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class)))

	public ResponseEntity<?> authenticateUser(@RequestBody UserDto loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		String token = jwtTokenProvider.generateToken(authentication);

		return ResponseEntity.ok(new JwtAuthenticationResponse(token));
	}
}