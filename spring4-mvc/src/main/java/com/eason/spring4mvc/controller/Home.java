package com.eason.spring4mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

	@RequestMapping("/index")
	public String home(Model model) {// model中的信息在视图中可以通过request获取到
		model.addAttribute("msg", "hello world!!! this msg from model.");
		return "index";
	}
	
	// 需要把webapp下面的index.jsp删除了，不然默认访问这个jsp
	@RequestMapping("/")
	public String index() { 
		return "index";
	}
}
