package com.obapi.apique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication
public class ApiqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiqueApplication.class, args);
		System.out.println("Apique Application Started");
	}
}
