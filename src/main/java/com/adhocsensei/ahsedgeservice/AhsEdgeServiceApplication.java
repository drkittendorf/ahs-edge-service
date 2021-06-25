package com.adhocsensei.ahsedgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AhsEdgeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AhsEdgeServiceApplication.class, args);
	}

}
