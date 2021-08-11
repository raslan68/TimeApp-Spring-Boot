package com.ramiaslan.timeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TimeAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(TimeAppApplication.class, args);
	}

}
