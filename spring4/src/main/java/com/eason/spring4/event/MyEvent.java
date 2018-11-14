package com.eason.spring4.event;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

	private String msg;

	public MyEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
