package com.proj.phase3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.phase3.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	
}
