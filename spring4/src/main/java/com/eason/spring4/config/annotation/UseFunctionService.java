package com.eason.spring4.config.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {

	@Autowired
	public FunctionService service;

	public void doSaying() {
		service.saying();
	}
}
