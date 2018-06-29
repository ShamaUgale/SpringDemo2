package com.springdemo.controller.User;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	@Autowired
	private UserDao service;
	
	@GetMapping(path = "/users")
	public List<User> getAllUsers(){
		return service.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable int id){
		User found= service.finOne(id);
		if(found==null){
			throw new UserNotFoundException("No use found with id - " +id);
		}
		return found;
	}
	
	/*
	 * input : user details
	 * output : CREATED and return the created URI
	 */
	@PostMapping (path = "/users")
	public void createUser(@RequestBody User user){
		User savedUser= service.save(user);
		
		// how to send the ccreated status - 201
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		ResponseEntity.created(location);
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id){
		User found= service.deleteUser(id);
		if(found==null){
			throw new UserNotFoundException("No use found with id - " +id + " to delete");
		}
	}
	
}
