package com.eason.spring4mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.eason.spring4mvc")
public class MyMvcConfig extends WebMvcConfigurerAdapter { // WebMvcConfigurerAdapter
															// 并不是必须的，需要增加高级特性的时候需要

	@Bean // 自动增加一些试图解析器
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/assets/**")
				.addResourceLocations("classpath:/assets/");
		registry.addResourceHandler("/pics/**")
				.addResourceLocations("classpath:/pics/");
		registry.addResourceHandler("/js/**")
				.addResourceLocations("classpath:/js/");
	}

	@Bean // 创建一个拦截器
	public MyInterceptor myInterceptor() {
		return new MyInterceptor();
	}

	@Override // 添加拦截器，并设置拦截规则
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(myInterceptor())
				.addPathPatterns("/assets/**")
				.addPathPatterns("/pics/**")
				.addPathPatterns("/request/**")
				.addPathPatterns("/response/**");
//				.addPathPatterns("/**");
	}
}
