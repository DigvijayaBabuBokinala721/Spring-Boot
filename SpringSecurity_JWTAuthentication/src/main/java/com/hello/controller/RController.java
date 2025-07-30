package com.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hello.entity.Users;
import com.hello.service.CustomUserDetailsService;
import com.hello.service.JWTService;

@RestController
public class RController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JWTService jwtService;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		return customUserDetailsService.register(user);
	}
	
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		
		
		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		if(auth.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		}
		else {
			return "failed";
		}
	}
	
}
