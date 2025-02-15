package com.practica.edp;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@RequiredArgsConstructor
public class EdpApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EdpApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

	}
}
