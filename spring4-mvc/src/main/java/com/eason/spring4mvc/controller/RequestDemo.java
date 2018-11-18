package com.eason.spring4mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/request")
public class RequestDemo {

	@RequestMapping(produces = "text/plain; charset=UTF-8")
	// 参数 HttpServletRequest 和 HttpServletResponse 根据需要添加
	public @ResponseBody String index(HttpServletRequest request){
		return "url: " + request.getRequestURL() + " can access!";
	}
	
	@RequestMapping("/index-2") // 纯文本返回时，没有指定 produces 照样可以，自动识别
	@ResponseBody // 可以放在方法上面或者返回值上
	public String index2(HttpServletRequest request){
		return "url: " + request.getRequestURL() + " can access!";
	}
}
