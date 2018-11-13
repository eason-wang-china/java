package com.eason.spring4.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.eason.spring4.javaconfig")
public class JavaConfig {

	/*
	 * @Bean public UseFunctionService useFunctionService() { UseFunctionService
	 * useFunctionService = new UseFunctionService();
	 * useFunctionService.setFunctionService(functionService()); return
	 * useFunctionService; }
	 */

	// 這種配置方式和上面是等價的
	@Bean
	public UseFunctionService useFunctionService(FunctionService service) {
		UseFunctionService useFunctionService = new UseFunctionService();
		useFunctionService.setFunctionService(service);
		return useFunctionService;
	}

	@Bean
	public FunctionService functionService() {
		return new FunctionService();
	}
}
