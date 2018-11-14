package com.eason.spring4.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	@Pointcut("@annotation(com.eason.spring4.aop.Action)")
	public void annotationPointCut() {};

	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint) {
		MethodSignature s = (MethodSignature) joinPoint.getSignature();
		Method m = s.getMethod();
		Action a = m.getAnnotation(Action.class);
		System.out.println("使用注解方式拦截：" + m.getName() + " -- " + a.name());
	}

	@Before("execution(* MethodService.*(..))")
	public void before(JoinPoint joinPoint) {
		MethodSignature s = (MethodSignature) joinPoint.getSignature();
		Method m = s.getMethod();
		System.out.println("使用方法规则方式拦截：" + m.getName());
	}

	@Before("execution(* com.eason.spring4.aop.MethodService.*(..))") // 可以增加多个拦截
	public void otherBefore(JoinPoint joinPoint) {
		MethodSignature s = (MethodSignature) joinPoint.getSignature();
		Method m = s.getMethod();
		System.out.println("使用第二个方法规则方式拦截：" + m.getName());
	}

	/*
	 * 注意第一个 * 后面一定要有空格，使用*来代表任意字符 
	 * 括号里面的 .. 代表任意参数 
	 * 多个 execution 可以使用 || 分割
	 * 
	 * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?) 
	 * 有“?”号的部分表示可省略的
	 * modifers-pattern 表示修饰符如 public、protected等 
	 * ret-type-pattern 表示方法返回类型
	 * declaring-type-pattern 代表特定的类 
	 * name-pattern 代表方法名称 
	 * param-pattern 表示参数
	 * throws-pattern 表示抛出的异常
	 **/
}
