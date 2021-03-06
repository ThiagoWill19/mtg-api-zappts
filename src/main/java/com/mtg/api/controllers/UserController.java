package com.mtg.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtg.api.models.User;
import com.mtg.api.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody User user){
		
		if(!userRepository.existsByName(user.getName())) {
			
			return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
			
		}else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Name already exist!");
	}
	
	
	
}
