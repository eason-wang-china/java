package com.eason.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eason.cloud.domain.User;
import com.eason.cloud.dto.UserDto;
import com.eason.cloud.service.SpringService_1;

@RestController
public class HelloApiController implements SpringService_1{

	@Value("${server.port}")
	int port;

	@Override
	public String hello() {

		return "hello eason, this is HelloApiController.hello()";
	}

	@Override
	public UserDto hello(String name, Integer age) {
		
		return new UserDto(name, age, "男", port);
	}

	@Override
	public String hello(UserDto user) {
		
		return "hello, user: " + user;
	}
}
