package com.eason.spring4.aop;

import org.springframework.stereotype.Service;

@Service
public class MethodService {

	public void add() {
		System.out.println("-- do MethodService.add() --");
	}
}
