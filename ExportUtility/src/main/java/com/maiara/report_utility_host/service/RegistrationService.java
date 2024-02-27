package com.maiara.report_utility_host.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiara.report_utility_host.model.User;
import com.maiara.report_utility_host.repository.RegistrationRepository;

//mediater take req from controller pass to repo and pass response from repo to controller 
@Service


public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	public User saveUser(User user) {
		
		return repo.save(user);
		
	}
	
	public User fetchUserByEmailId(String emailId) {
		
		return repo.findByEmailId(emailId); //just declare method in repo the jpa will create as its inbuild method and write the query by its own
	}
	
	public User fetchUserByEmailIdAndPassword(String emailId, String password) {
		
		return repo.findByEmailIdAndPassword(emailId, password);
	}

}
