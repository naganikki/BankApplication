package com.config.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringconfigcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringconfigcloudApplication.class, args);
		System.out.println("Config Server for bank application is running...");
	}

}
