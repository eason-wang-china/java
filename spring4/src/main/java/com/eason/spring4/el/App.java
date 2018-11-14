package com.eason.spring4.el;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ElConfig.class);

		ElConfig config = ctx.getBean(ElConfig.class);
		config.outputResult();
		
		ctx.close();
	}

}
