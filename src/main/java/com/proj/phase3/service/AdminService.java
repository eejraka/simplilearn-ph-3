package com.proj.phase3.service;

import com.proj.phase3.model.Admin;

public interface AdminService {
	//login entity response type string
	String getPass();
	//password change is basically update
	Admin updatePass(String pass);
}
