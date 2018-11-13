package com.eason.spring4.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		UseFunctionService service = ctx.getBean(UseFunctionService.class);
		service.doSaying();
		ctx.close();
	}

}
