package com.messenger.ws.auth;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.messenger.ws.error.ApiError;
import com.messenger.ws.shared.Views;
import com.messenger.ws.user.User;
import com.messenger.ws.user.UserRepository;

////@RestController
//public class AuthControllerWithoutSpringSecurity {
//	
//	private static final Logger log = LoggerFactory.getLogger(AuthControllerWithoutSpringSecurity.class); 
//	
//	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	
////	@Autowired
////	UserRepository userRepository;
////	
//
//////	@PostMapping("/api/1.1/auth123")
//////	@JsonView(Views.Base.class)
////	ResponseEntity<?> handleAuthentication(@RequestHeader(name="Authorization",required = false) String authorization) {
////		System.out.println("Adas");
////		log.info(authorization);	
////		if(authorization == null) {
////			ApiError error = new ApiError(401, "unauthorized request", "/api/1.0/auth");
////			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
////		}
////		log.info(authorization);
////		
////		String base64encoded = authorization.split("Basic ")[1];
////		String decoded = new String(Base64.getDecoder().decode(base64encoded));
////		String[] parts= decoded.split(":"); //["user1", "P4assword"]
////		String username = parts[0];
////		String password = parts[1];
////		User inDB = userRepository.findByUsername(username);
////		if(inDB == null) {
////			ApiError error = new ApiError(401, "unauthorized request", "/api/1.0/auth");
////			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
////		}
////		String hashedPassword = inDB.getPassword();
////		if(!passwordEncoder.matches(password, hashedPassword)){
////			ApiError error = new ApiError(401, "unauthorized request", "/api/1.0/auth");
////			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
////		};
//		
//		//username, displayname, image
////		Map<String,String> responseBody = new HashMap<>();
////		responseBody.put("username", inDB.getUsername());
////		responseBody.put("displayName", inDB.getDisplayName());
////		responseBody.put("image", inDB.getImage());
////		return ResponseEntity.ok(responseBody);
//
//		//JsonView Yöntemi ile yaparsak >
//		return ResponseEntity.ok(inDB);
//	}
//}
