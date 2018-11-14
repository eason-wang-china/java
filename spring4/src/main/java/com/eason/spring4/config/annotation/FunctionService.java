package com.eason.spring4.config.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

@Service
public class FunctionService {

	@PostConstruct
	public void init() {
		System.out.println("FunctionService use jsr250 init method!!!");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("FunctionService use jsr250 destroy method!!!");
	}
	
	public void saying() {
		System.out.println("this is eason!!!");
	}
}
