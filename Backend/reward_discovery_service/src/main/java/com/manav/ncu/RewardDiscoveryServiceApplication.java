package com.manav.ncu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RewardDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardDiscoveryServiceApplication.class, args);
	}

}
