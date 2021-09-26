package com.bookmyshow.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookmyshow.model.User;
import com.bookmyshow.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/getAll/{username}")
	public List<User> getAllUsers(@PathVariable String username){
		return userRepository.findByUsername(username);
	}

	@GetMapping("/get/{username}/user/{id}")
	public User getTodo(@PathVariable String username, @PathVariable long id){
		return userRepository.findById(id).get();
	}

	@DeleteMapping("/delete/{username}/{id}")
	public ResponseEntity<Void> deleteTodo(
			@PathVariable String username, @PathVariable long id) {
		userRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/update/{username}/{id}")
	public ResponseEntity<User> updateTodo(
			@PathVariable String username,
			@PathVariable long id, @RequestBody User user){
		
		user.setUsername(username);
		User userUpdated = userRepository.save(user);
		return new ResponseEntity<User>(userUpdated, HttpStatus.OK);
	}
	
	@PostMapping("/create/{username}")
	public ResponseEntity<Void> createUser(
			@PathVariable String username, @RequestBody User user){
		
		user.setUsername(username);
		User createdUser = userRepository.save(user);
		
		//Location
		//Get current resource url
		///{id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdUser.getUserId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
		
}
