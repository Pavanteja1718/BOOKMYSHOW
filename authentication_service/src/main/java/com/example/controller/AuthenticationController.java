package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginRequestUser;
import com.example.dto.MessageResponse;
import com.example.dto.UserSignupRequest;
import com.example.entity.User;
import com.example.security.jwt.JwtUtils;
import com.example.service.UserService;

@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
@RestController
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserService userService;


	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public String authenticateUser(@Validated @RequestBody LoginRequestUser loginRequestUser) {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginRequestUser.getUsername(), loginRequestUser.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);


		return 	jwtUtils.generateJwtToken(authentication);

	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Validated @RequestBody UserSignupRequest signUpRequest) {

		if (userService.existsByUserName(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse(" UserName is Present try another!"));
		}

		if (userService.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Email is  present try another!"));
		}

		// To create new user(student)
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		userService.addUser(user);

		return ResponseEntity.ok(new MessageResponse("New User registered!"));
	}

}