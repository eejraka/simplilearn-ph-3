package com.proj.phase3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.phase3.dto.Logclass;
import com.proj.phase3.dto.Temp;
import com.proj.phase3.service.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	

	@PostMapping("/login")
	public ResponseEntity<String> logIn(@RequestBody Temp temp){
		if(temp.getEnteredPass().equals(adminService.getPass())) {
			return new ResponseEntity<String>("Login Successful", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Wrong Password", HttpStatus.OK);
	}
	
	@PostMapping("/changepass")
	public ResponseEntity<String> changePass(@RequestBody Logclass log){
		if(!log.getCurrPass().equals(adminService.getPass())) {
			return new ResponseEntity<String>("Current password is incorrect", HttpStatus.OK);
		}
		
		adminService.updatePass(log.getNewPass());
		return new ResponseEntity<String>("Password changed Successfully", HttpStatus.OK);
	}
}
