package com.eason.springboot.web.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eason.springboot.config.ProjectSettings;
import com.eason.springboot.config.TestConfig;

@RestController
public class HomeController {
	
	@Resource
	private ProjectSettings settings;
	
	@Autowired
	// @Qualifier("testConfig")
	private TestConfig testConfig;
	
	@Value("${i.want.say}") // 从 application.properties 直接获取数据
	private String saySomething;
	
	@RequestMapping("/")
	String index(){
		return "Hello Eason Wang. " + saySomething;
	}
	
	@RequestMapping("/settings")
	String showSettings(){
		return settings.toString();
	}
	
	@RequestMapping("/test-config")
	String showTestConfig(){
		return testConfig.toString();
	}

}
