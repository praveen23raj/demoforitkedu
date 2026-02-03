package com.example.praveen.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class DemoForApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoForApplication.class, args);
	}


	@PostConstruct
	public void init() {
		// Fix the TimeZone issue by setting it to a standard value
		// "Asia/Kolkata" is the modern value for IST
		// "UTC" is the best practice for financial apps (Wallet)
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
