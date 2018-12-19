package com.eason.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.eason.springboot.web.servlet.SecondServlet;

@Configuration
public class MvcConfig /*extends WebMvcConfigurerAdapter*/ implements WebMvcConfigurer{ // 已经不再推荐使用 WebMvcConfigurerAdapter 

	@Autowired
    private ApplicationContext applicationContext; // 再需要全局环境变量的时候，直接注入就可以
    
	@Override // 把请求直接映射为视图
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/sse").setViewName("sse");
	}
	
	@Bean // 方式二：加载servlet
    public ServletRegistrationBean servletRegistrationBean(){
		SecondServlet servlet = new SecondServlet();
		servlet.setProjectSettings(applicationContext.getBean(ProjectSettings.class));
		
        ServletRegistrationBean bean = new ServletRegistrationBean(servlet);
        bean.addUrlMappings("/servlet/second");
        return bean;
    }
	
}
