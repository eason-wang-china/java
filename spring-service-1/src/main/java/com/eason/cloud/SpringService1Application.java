package com.eason.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringService1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringService1Application.class, args);
	}

}
