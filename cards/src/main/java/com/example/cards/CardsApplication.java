package com.example.cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.cards.dto.ConfigPropertiesDto;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAware")
@EnableConfigurationProperties(value = {ConfigPropertiesDto.class})
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
		System.out.println("Cards application running...");
	}

}
