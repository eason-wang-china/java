package com.eason.spring4.aop;

import org.springframework.stereotype.Service;

@Service
public class AnnotationService {

	@Action(name = "通过注解式拦截的操作，这是Action的参数！！！")
	public void add() {
		System.out.println("-- do AnnotationService.add() --");
	}
}
