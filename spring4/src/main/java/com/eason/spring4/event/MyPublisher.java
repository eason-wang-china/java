package com.eason.spring4.event;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyPublisher {

	@Resource
	ApplicationContext ctx;

	public void publish(String msg) {

		ctx.publishEvent(new MyEvent(this, msg));
	}
}
