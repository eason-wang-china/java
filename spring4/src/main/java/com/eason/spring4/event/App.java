package com.eason.spring4.event;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EventConfig.class);

		MyPublisher p = ctx.getBean(MyPublisher.class);
		p.publish("我是消息...");
		
		ctx.close();
	}

}
