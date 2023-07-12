package com.proj.phase3.service;

import java.util.List;

import com.proj.phase3.model.User;

public interface UserService {
	List<User> getAllUsers();
	List<User> findUserByName(String name);
	List<User> findUserByEmail(String email);
}
