package com.example.jwt.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.api.entity.AuthRequest;
import com.example.jwt.api.util.JwtUtil;

@RestController
public class SpringController {
	
	@Autowired
	private JwtUtil jwtUtil;
  
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String welcome() {
		return "Spring Security!!";
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword())
				);   //validate userName and password
	} catch(Exception e) {
		throw new Exception("invalid username/password");
	}
		return jwtUtil.generateToken(authRequest.getUserName());
	}
	
	
}
