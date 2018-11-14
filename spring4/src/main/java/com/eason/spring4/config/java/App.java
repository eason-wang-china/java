package com.eason.spring4.config.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// 基础测试
		// UseFunctionService service = ctx.getBean(UseFunctionService.class); // 因为JavaConfig配置中出现了两个，所以不能使用这种方式获取Bean了
		UseFunctionService ufService = ctx.getBean("useFunctionServiceOther", UseFunctionService.class);// 可以通过字符串名字获取，名字就是方法名
		ufService.doSaying();
		
		//测试Bean的创建次数
		FunctionService fService = ctx.getBean(FunctionService.class);
		fService.saying();
		
		ctx.close();
	}

}
