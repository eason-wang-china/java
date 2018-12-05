package com.eason.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@RequestMapping({ "/", "" })
	String Home(Model model) {

		log.info("Hello, this is home controller!");

		// 设置页面上需要的属性
		model.addAttribute("myName", "Eason Wang");

		return "home";
	}

	@RequestMapping(value = "/return-chinese", produces = "text/html;charset=UTF-8")
	@ResponseBody
	String returnChinese() {

		return "注意：因为这个请求返回的是文本类型，所以需要加上 produces = \"text/plain;charset=UTF-8\"，否则容易出现中文乱码！";
	}

	@RequestMapping("/return-chinese-2")
	void returnChinese_2(HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("注意：因为这个响应是直接通过 Response 处理的，所以这个方法不需要返回值！");
	}
}
