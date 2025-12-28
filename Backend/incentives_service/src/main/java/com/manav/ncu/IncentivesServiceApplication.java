package com.manav.ncu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IncentivesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncentivesServiceApplication.class, args);
	}

}
