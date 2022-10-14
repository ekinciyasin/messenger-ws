package com.messenger.ws.user;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.messenger.ws.error.ApiError;
import com.messenger.ws.shared.GenericResponse;

@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/1.0/users")
	@ResponseStatus(HttpStatus.CREATED)  //spring default olarak 200 döner biz burada defaultu degisitirmis olduk
	public GenericResponse createUser(@Valid @RequestBody User user) {
		
		userService.save(user);
		
		return new GenericResponse("user created");
	
	}	
	@GetMapping("/api/1.0/login")
	@ResponseStatus(HttpStatus.OK)  //spring default olarak 200 döner biz burada defaultu degisitirmis olduk
	public void loginUser(@RequestBody User user) {
		log.info(user.getUsername());
		
		
		
		
	}	
	
	//bu classin dahil oldugu bir zincirde MethodArgumentNotValidException atilirsa bu method calisacak.
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST) //Bunu belirtmezsek spring default olarak 200 gönderir.
	public ApiError handleValidationException(MethodArgumentNotValidException ex) {

		ApiError error = new ApiError(400, "validation error", "/api/1.0/users");
		Map<String,String>validationErrors = new HashMap<>();

		for(FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		error.setValidationErrors(validationErrors);
		return error;
	}
}








/**
 * Validation in sprin degilde biz yaparsak yapmamiz gerekenler.
@PostMapping("/api/1.0/users")
public ResponseEntity<?> createUser(@RequestBody User user) {
	ApiError error = new ApiError(400, "Validation error", "/api/1.0/users");
	Map<String, String> validationErrors = new HashMap<>();

	String username = user.getUsername();
	String displayName = user.getDisplayName();
	
	if(username == null || username.isEmpty()) {
		validationErrors.put("username", "Username cannot be null");
	}
	
	if(displayName == null || displayName.isEmpty()) {
		validationErrors.put("displayName", "Cannot be null");
	}
	if(validationErrors.size() > 0) {
		error.setValidationErrors(validationErrors);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	
	userService.save(user);
	return ResponseEntity.ok(new GenericResponse("user created"));
}
  **/
