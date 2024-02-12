package com.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.entity.User;
import com.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String fine()
	{
		return "Workinf fine";
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1= userservice.SaveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
		
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userid)
	{
		User user=userservice.getUser(userid);
		return ResponseEntity.ok(user);
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> user=userservice.getAllUser();
		
		return ResponseEntity.ok(user);
		
	}
	
	

}
