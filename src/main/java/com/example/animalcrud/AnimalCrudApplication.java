package com.example.animalcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Annotation to mark this class as a Spring Boot application
@SpringBootApplication
public class AnimalCrudApplication {

	// Main method to run the Spring Boot application
	public static void main(String[] args) {
		// Running the Spring Boot application
		SpringApplication.run(AnimalCrudApplication.class, args);
		// Print a message to the console indicating the application is running
		System.out.println("Application is running Fine...");
	}

}