package com.proj.phase3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.phase3.exception.ResourceNotFoundException;
import com.proj.phase3.model.User;
import com.proj.phase3.repository.UserRepository;
import com.proj.phase3.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public List<User> findUserByName(String name) {
		List<User> temp = userRepo.findByUnameIs(name);
		
		if(temp.isEmpty()) {
			throw new ResourceNotFoundException("Users", "Name", name);
		}
		
		return temp;
	}

	@Override
	public List<User> findUserByEmail(String email) {
		List<User> temp = userRepo.findByEmailIs(email);
		
		if(temp.isEmpty()) {
			throw new ResourceNotFoundException("Users", "Email", email);
		}
		
		return temp;
	}
	
	

}
