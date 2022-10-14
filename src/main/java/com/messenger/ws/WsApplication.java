  package com.messenger.ws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.messenger.ws.user.User;
import com.messenger.ws.user.UserService;

@SpringBootApplication
public class WsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsApplication.class, args);
	}

	
//	initilization aninda bir user olusturmak icin kullaniyoruz.
	@Bean
	CommandLineRunner createInitialUsers(UserService userService) {
		return (args) -> {

				User user = new User();
				user.setUsername("user1");
				user.setDisplayName("display1");
				user.setPassword("P4ssword");
				user.setImage("image");
				
				
				userService.save(user);
			
				
			
		};
	} 
}
