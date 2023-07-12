package com.proj.phase3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.phase3.exception.ResourceNotFoundException;
import com.proj.phase3.model.Admin;
import com.proj.phase3.repository.AdminRepository;
import com.proj.phase3.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public String getPass() {
		Admin top = adminRepo.findById((long) 1).orElseThrow(() ->
				new ResourceNotFoundException("Admin", "ID", 1));
		
		return top.getApass();
	}


	@Override
	public Admin updatePass(String pass) {
		Admin top = adminRepo.findById((long) 1).orElseThrow(() ->
		new ResourceNotFoundException("Admin", "ID", 1));
		top.setApass(pass);
		adminRepo.save(top);
		return top;
	}

}
