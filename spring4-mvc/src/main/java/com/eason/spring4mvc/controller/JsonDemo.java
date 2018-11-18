package com.eason.spring4mvc.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eason.spring4mvc.controller.params.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/json")
public class JsonDemo {

	@RequestMapping("")
	public String index() {
		return "json";
	}
	
	@RequestMapping(value = "/submit-json")
	public void setJson(
			@RequestBody Book book, // @RequestBody 根据json数据，转换成对应的Object
			HttpServletResponse response) throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();// ObjectMapper类是Jackson库的主要类。它提供一些功能将Java对象转换成对应的JSON格式的数据
		System.out.println(mapper.writeValueAsString(book));// 将book对象转换成json输出
		
		book.setAuthor("肖文吉");
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(mapper.writeValueAsString(book));// 将book对象转换成json写出到客户端
	}
}
