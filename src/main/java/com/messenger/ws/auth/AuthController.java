package com.messenger.ws.auth;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.messenger.ws.configuration.MessengerUserDetails;
import com.messenger.ws.shared.CurrentUser;
import com.messenger.ws.shared.Views;
import com.messenger.ws.user.User;
import com.messenger.ws.user.UserRepository;

@RestController
public class AuthController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/api/1.0/auth")
	@JsonView(Views.Base.class)
	ResponseEntity<?> handleAuthentication(@CurrentUser User user) {
		System.out.println("auth");
		return ResponseEntity.ok(user);
	}
	

}