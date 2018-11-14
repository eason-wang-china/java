package com.eason.spring4.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class MyService implements ApplicationListener<MyEvent> {

	@Override
	public void onApplicationEvent(MyEvent event) {

		String msg = event.getMsg();
		System.out.println("I receive msg is :" + msg);
	}

}
