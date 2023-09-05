package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.WinnerRequest;
import com.example.demo.entity.User;
import com.example.demo.entity.Winner;
import com.example.demo.repository.WinnerRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v3/winner")
@Api(value="winner", description=" Api winner")
@CrossOrigin(origins = "http://localhost:3000/", exposedHeaders = "Authorization")
public class WinnerController {

	@Autowired
	private WinnerRepository winnerRepository;

	@PostMapping("/saveRandomWinner")
	@ApiOperation(value = "saveRandomWinner.", response = Winner.class)
	public String saveRandomWinnerPhoneNumber(@RequestBody WinnerRequest winnerRequest) {
		String randomPhoneNumber = winnerRequest.getRandomPhoneNumber();
		String winnerType = winnerRequest.getType();
		if (randomPhoneNumber != null) {
			Winner winner = new Winner();
			winner.setPhoneNumber(randomPhoneNumber);
			winner.setType(winnerType);
			winner.setDate(new Date()); // Set the winning date

			winnerRepository.save(winner);
			return "Random winner phone number saved.";
		} else {
			return "No phone numbers available to save.";
		}
	}
}
