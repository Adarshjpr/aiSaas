package com.project.aiSaas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity   
public class aiSaas {

	public static void main(String[] args) {
		SpringApplication.run(aiSaas.class, args);
	}

}
