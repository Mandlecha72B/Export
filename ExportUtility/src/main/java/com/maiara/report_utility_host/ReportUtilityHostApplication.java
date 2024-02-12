package com.maiara.report_utility_host;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.maiara.report_utility_host", "com.maiara.report_utility" })
@EntityScan(basePackages = { "com.maiara.report_utility_host", "com.maiara.report_utility" })
@EnableJpaRepositories(basePackages = { "com.maiara.report_utility_host","com.maiara.report_utility.database.repository" })
@SpringBootApplication
public class ReportUtilityHostApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportUtilityHostApplication.class, args);
	}

}
