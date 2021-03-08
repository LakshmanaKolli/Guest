package com.epam.guest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyHotelApplication.class, args);
	}

}
