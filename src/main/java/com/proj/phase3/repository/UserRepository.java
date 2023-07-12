package com.proj.phase3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.phase3.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByUnameIs(String name);
	List<User> findByEmailIs(String email);
}
