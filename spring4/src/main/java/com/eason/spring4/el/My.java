package com.eason.spring4.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class My {

	@Value("Eason wang")	// 直接注入属性
	private String name;
	@Value("36")
	private int age;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
