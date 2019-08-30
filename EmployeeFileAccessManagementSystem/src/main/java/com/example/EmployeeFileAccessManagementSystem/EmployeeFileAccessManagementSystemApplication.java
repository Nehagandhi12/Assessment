package com.example.EmployeeFileAccessManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.Dao", "com.example.AllControllers",
		"com.example.EmployeeFileAccessManagementSystem", "com.example.Business" })
@EntityScan(basePackages = { "com.example.Bean" })
@EnableJpaRepositories(basePackages = { "com.example.Repositories" })
public class EmployeeFileAccessManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeFileAccessManagementSystemApplication.class, args);

	}

}
