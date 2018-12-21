package com.eason.cloud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eason.cloud.domain.User;

@RestController
@RequestMapping("/response")
public class RestResponseController {

	@Value("${server.port}")
	private int serverPort;

	@RequestMapping("/get-map")
	public Map<String, Object> getMap(String name, int age, String sex) {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("name", name);
		result.put("age", age);
		result.put("sex", sex);
		result.put("port", serverPort);
		return result;
	}

	@RequestMapping("/get-user")
	public User getUser(Integer id) {

		User result = new User("Eason wang", 36, "男", serverPort);
		return result;
	}
}
