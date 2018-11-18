package com.eason.spring4mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*
拦截器的使用场景，处理所有请求共性问题：
1、乱码问题：用request，response参数去设置编码
2、解决权限验证问题（是否登陆，取session对象查看）

拦截器与过滤器的区别：
1、拦截器Interceptor依赖于框架容器，基于反射机制，只过滤请求
2、过滤器Filter依赖于Servlet容器，基于回调函数，过滤范围大
*/
public class MyInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler // handler 表示的是被拦截的请求的目标对象
			) throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true; // 返回值说明是否需要将当前的请求拦截下来，false：请求将被终止，true：请求会被继续运行
	}
	
	@Override
	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, // handler 表示的是被拦截的请求的目标对象
			ModelAndView modelAndView // 可以通过modelAndView参数改变显示的视图，或者修改发往视图的方法
			) throws Exception {
		long startTime = (Long)request.getAttribute("startTime");
		request.removeAttribute("startTime");
		long endTime = System.currentTimeMillis();
		System.out.println("本次处理时间: " + (endTime - startTime) + "s");
	}

	 // 在视图加载完毕之后调用，常用于作于资源的销毁，流等，类似于析构函数 
	 @Override
	 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	   throws Exception {
	  System.out.println("TestInterceptor.afterCompletion()"); 
	 }
}
