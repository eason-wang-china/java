package com.eason.spring4.config.java;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FunctionService {

	@PostConstruct
	public void init() {
		System.out.println("FunctionService use jsr250 init method!!!");
	}
	
//	@PreDestroy // 多个实例只被执行了一次销毁
	public void destroy() {
		System.out.println("FunctionService use jsr250 destroy method!!!");
	}
	
	public FunctionService() {
		System.out.println("++执行FunctionService构造函数++\n");
	}
	
	public void saying() {
		System.out.println("this is eason!!!\n");
	}
}
