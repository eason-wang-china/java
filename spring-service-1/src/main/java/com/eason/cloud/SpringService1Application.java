package com.eason.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.eason.cloud.config.MyApplicationEnvironmentPreparedEventListener;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringService1Application {

	public static void main(String[] args) {

		// SpringApplication.run(SpringService1Application.class, args);
		SpringApplication app = new SpringApplication(SpringService1Application.class);
		app.addListeners(new MyApplicationEnvironmentPreparedEventListener());
		app.run(args);
	}

}
