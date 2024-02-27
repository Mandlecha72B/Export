package com.maiara.report_utility_host.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {
	@GetMapping("/connection-test")
	public void test()  {
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=Sakshi");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");
			ResultSet resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
