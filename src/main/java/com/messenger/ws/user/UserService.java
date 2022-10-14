package com.messenger.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	private UserRepository repository;
	
	
	PasswordEncoder passwordEncoder;
	
	//tek bir constructor varsa @Autowired kullanmasak da olur.
   	@Autowired
 	public UserService(UserRepository repository,PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}



	public void save(User user) {
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		System.out.println(user.toString());
		repository.save(user);
	}
}
