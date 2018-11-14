package com.eason.spring4.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
// @ComponentScan("com.eason.spring4.javaconfig")
public class JavaConfig {

	// 方法名 和 返回值 不能和下面的完全一样，否则只能执行其中的一个
	@Bean
	public UseFunctionService useFunctionServiceOther() {
		System.out.println("--UseFunctionServiceOther 被创建了--");
		UseFunctionService useFunctionService = new UseFunctionService();
		useFunctionService.setFunctionService(functionService());
		return useFunctionService;
	}

	// 這種配置方式和上面是等價的
	@Bean
	public UseFunctionService useFunctionService(FunctionService service) {
		System.out.println("--UseFunctionService 被创建了--");
		UseFunctionService useFunctionService = new UseFunctionService();
		useFunctionService.setFunctionService(service);
		return useFunctionService;
	}

	@Bean
//	@Scope("singleton")
	@Scope("prototype") // 每次都会被执行
	public FunctionService functionService() {
		System.out.println("++FunctionService 被创建了++");
		return new FunctionService();
	}
}
