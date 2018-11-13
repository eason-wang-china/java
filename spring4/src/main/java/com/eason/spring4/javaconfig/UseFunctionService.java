package com.eason.spring4.javaconfig;

public class UseFunctionService {

	public FunctionService service;

	public void setFunctionService(FunctionService service) {
		this.service = service;
	}

	public void doSaying() {
		service.saying();
	}
}
