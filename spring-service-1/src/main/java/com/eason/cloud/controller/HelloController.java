package com.eason.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eason.cloud.domain.User;

@RestController
public class HelloController {

	@Value("${server.port}")
	int port;

	@RequestMapping("/hello")
	public String index() {

		return "hello eason!!! port: " + port + " time: " + System.currentTimeMillis();
	}
	
	@RequestMapping("/hello-2")
	public User index2(@RequestHeader String name, @RequestHeader Integer age) {

		return new User(name, age, "男", port);
	}
	
	@RequestMapping("/hello-3")
	public String index3(@RequestBody User user) {

		return "hello, user: " + user;
	}
}
