package com.eason;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class App implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletCtx) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(MvcConfig.class); // 也可以指定一个包名，扫面下面所有标注了 @Configuration 的类，实现多配置类
		ctx.setServletContext(servletCtx);
		
		Dynamic servlet = servletCtx.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
	}

}
