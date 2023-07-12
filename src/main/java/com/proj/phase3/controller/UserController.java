package com.proj.phase3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.phase3.model.User;
import com.proj.phase3.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.FOUND);
	}
	
	@GetMapping("/findname/{name}")
	public ResponseEntity<List<User>> findUserByName(@PathVariable String name){
		return new ResponseEntity<List<User>>(userService.findUserByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/findemail/{email}")
	public ResponseEntity<List<User>> findUserByEmail(@PathVariable String email){
		return new ResponseEntity<List<User>>(userService.findUserByEmail(email), HttpStatus.OK);
	}
}
