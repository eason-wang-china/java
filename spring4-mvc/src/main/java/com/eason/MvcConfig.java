package com.eason;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({"com.eason.controller", "com.eason.service"})
// WebMvcConfigurerAdapter 并不是必须的，需要增加高级特性的时候需要才继承，重写方法
public class MvcConfig extends WebMvcConfigurerAdapter { 

	@Bean // 自动增加一些试图解析器
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/"); // 因为放在了类路径的 resources 下，输出会在 class 目录下面
		// viewResolver.setPrefix("/WEB-INF/views/"); // 也可以放在 WEB-INF 下面
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	@Bean // 创建一个拦截器
	public MyInterceptor myInterceptor() {
		return new MyInterceptor();
	}

	@Override // 添加拦截器，并设置拦截规则
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(myInterceptor()) // Spring 5 才会拦截静态资源，所以需要在拦截器里面排除对静态资源的拦截，但是 Spring 4 根本就不会对静态资源拦截
				// .addPathPatterns("/assets/**")
				// .addPathPatterns("/pics/**")
				// .addPathPatterns("/request/**")
				// .addPathPatterns("/response/**")
				.addPathPatterns("/**");
	}
	
	@Override // 使用默认的 Servlet 来响应静态资源，资源可以放在 web 根目录下，比如 webapp、web-resources
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		super.configureDefaultServletHandling(configurer);
        configurer.enable();
    }
	
	@Override // 使用资源处理器，通常资源可以放在类路径下
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/assets/**")
				.addResourceLocations("classpath:/assets/");
		registry.addResourceHandler("/pics/**")
				.addResourceLocations("classpath:/pics/");
		registry.addResourceHandler("/js/**")
				.addResourceLocations("classpath:/js/");
	}
	
	@Override // 把请求直接映射为视图
	public void addViewControllers(ViewControllerRegistry registry) {
		 super.addViewControllers(registry);
		 registry.addViewController("/index").setViewName("index");
	}
}
