package com.eason.spring4.javaconfig;

public class UseFunctionService {

	public FunctionService service;
	
	public UseFunctionService() {
		System.out.println("--执行UseFunctionService构造函数--\n");
	}

	public void setFunctionService(FunctionService service) {
		this.service = service;
	}

	public void doSaying() {
		service.saying();
	}
}
