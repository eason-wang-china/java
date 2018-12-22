package com.eason.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/")
	public String index() {
		long start = System.currentTimeMillis();

		ResponseEntity<String> entity = restTemplate.getForEntity("http://spring-cloud-service-1/", String.class);

		return "result: " + entity.getBody() + " use: " + (System.currentTimeMillis() - start);
	}
}
