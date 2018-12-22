package com.eason.cloud.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eason.cloud.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/response")
public class RestResponseController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/get-map")
	public String index() {
		ResponseEntity<Map> entity = restTemplate.getForEntity(
				"http://spring-cloud-service-1/response/get-map?name={1}&age={2}&sex={3}", Map.class, 
				"eason wang", 
				36,
				"男");
		return "result: " + entity;
	}
	
	@HystrixCommand(fallbackMethod="fallback")
	@RequestMapping("/get-user-str")
	public String index_2() {
		String entity = restTemplate.getForObject(
				"http://spring-cloud-service-1/response/get-user?name={1}&age={2}&sex={3}", String.class, 
				"eason wang", 
				36,
				"男");
		return "result: " + entity;
	}
	
	@HystrixCommand(fallbackMethod="fallback")
	@RequestMapping("/get-user")
	public String index_3() {
		User entity = restTemplate.getForObject(
				"http://spring-cloud-service-1/response/get-user?name={1}&age={2}&sex={3}", User.class, 
				"eason wang", 
				36,
				"男");
		return "result: " + entity;
	}
	
	// 服务降级，返回一个静态结果或者缓存的结果
	public String fallback() {
		
		return "服务端错误，请稍后再尝试！";
	}
}
