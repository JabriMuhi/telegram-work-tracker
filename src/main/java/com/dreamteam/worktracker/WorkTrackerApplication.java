package com.dreamteam.worktracker;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkTrackerApplication {

	public static void main(String[] args) {
		// Init .env
		Dotenv dotenv = Dotenv.load();
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(WorkTrackerApplication.class, args);
	}

}
