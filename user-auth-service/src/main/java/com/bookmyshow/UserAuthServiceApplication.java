package com.bookmyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthServiceApplication.class, args);
	}

}
