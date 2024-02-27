package com.maiara.report_utility_host.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maiara.report_utility_host.model.User;

public interface RegistrationRepository  extends JpaRepository<User, Integer>{
	
	public User findByEmailId(String emaiId);
	
	public User findByEmailIdAndPassword(String emaiId, String password);

}
