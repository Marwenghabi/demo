package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Api(tags = "Users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "Register a new user", notes = "Registers a new user in the system.")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        String result = userService.addUser(userDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/hello")
    @ApiOperation(value = "Test endpoint", notes = "A simple test endpoint that returns a greeting.")
    public String hello() {
        return "Hello, World!";
    }
   
    // Other user-related endpoints can be added here
}
