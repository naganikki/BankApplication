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

@SpringBootApplication
@ComponentScans({@ComponentScan("com.web.spring.controller")})
@ComponentScan(basePackages = "com.web.spring")
@EnableJpaRepositories("com.web.spring.repository")
@EntityScan("com.web.spring.model")
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImpl")
@EnableConfigurationProperties(value = {ContactInfoDto.class})
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
		System.out.println("Loan Application Running...");
	}

}
