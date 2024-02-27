package com.maiara.report_utility_host.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.maiara.report_utility_host.model.User;
import com.maiara.report_utility_host.service.RegistrationService;

@RestController

public class RegistrationController {
	
	@Autowired
	
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		User userObj = null;
		if(tempEmailId!=null && !"".equals(tempEmailId)) {
			 userObj = service.fetchUserByEmailId(tempEmailId);
			if(userObj!=null) {
				throw new Exception("User with " + tempEmailId + " is already exist");
			}
		}
		
		userObj = service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		
		String tempemailId = user.getEmailId();
		String tempPassword = user.getPassword();
		User userObj = null;
		
		if(tempemailId!=null && tempPassword!=null) {
			userObj = service.fetchUserByEmailIdAndPassword(tempemailId, tempPassword);
		}
		
		if(userObj==null) {
			throw new Exception("Bad Credentials");
		}
		return userObj;
		
	}

}
