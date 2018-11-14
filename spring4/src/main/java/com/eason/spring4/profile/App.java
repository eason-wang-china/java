package com.eason.spring4.profile;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.getEnvironment().setActiveProfiles("prod");
		ctx.register(ProfileConfig.class);
		ctx.refresh();
		
		MyBean mBean = ctx.getBean(MyBean.class);
		System.out.println(mBean.getValue());
		
		YourBean yBean = ctx.getBean(YourBean.class);
		yBean.setValue("this is you bean+++");
		System.out.println(yBean.getValue());
		
		ctx.close();
	}

}
