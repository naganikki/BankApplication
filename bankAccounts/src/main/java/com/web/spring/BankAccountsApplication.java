package com.web.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.web.spring.dto.ContactInfoDto;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@ComponentScans({@ComponentScan("com.web.spring.controller")})
@EnableJpaRepositories("com.web.spring.repository")
@EntityScan("com.web.spring.model")
@EnableConfigurationProperties(value = {ContactInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAware")
@OpenAPIDefinition(
		info = @Info(
				title = "Nagaraju's Bank Application",
				description = "this is a microservices Application",
				version = "v1",
				contact = @Contact(
						name = "Nagaraju",
						email = "csenaga@gmail.com",
						url = "google.com"
						),
				license = @License(
						name = "Apache2.0",
						url = "google.com"
						)
				),
		externalDocs = @ExternalDocumentation(
				description = "no any external documentation available",
				url = "google.com"
				)
		)
public class BankAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountsApplication.class, args);
		System.out.println("Bank Accounts Application Running...");
	}

}
