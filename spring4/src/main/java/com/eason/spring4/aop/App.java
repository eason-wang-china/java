package com.eason.spring4.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
		
		MethodService mService = ctx.getBean(MethodService.class);
		mService.add();
		
		AnnotationService aService = ctx.getBean(AnnotationService.class);
		aService.add();
		
		ctx.close();
	}

}
