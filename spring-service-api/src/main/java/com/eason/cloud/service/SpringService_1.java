package com.eason.cloud.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eason.cloud.dto.UserDto;

@RequestMapping("/api")
public interface SpringService_1 {

	@RequestMapping("/hello")
	String hello();
	
	@RequestMapping("/hello-2")
	UserDto hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
	
	@RequestMapping("/hello-3")
	String hello(@RequestBody UserDto user);
	
	
}
