package com.software;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentWithSpringBootApplication.class, args);
		System.err.println("Spring boot started========================");
	}

}

