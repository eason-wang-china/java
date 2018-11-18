package com.eason.spring4mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eason.spring4mvc.controller.params.RequestObj;

@Controller
@RequestMapping("/model")
public class ModelDemo {

	
	@ModelAttribute // 其修饰的方法会优先于处理方法执行，不管处理方法中是否包含model
	public void myModel(String name, int id, Model model) {
		System.out.println("do model method...");
		RequestObj obj = new RequestObj(id, name);
		model.addAttribute("obj", obj);
	}
	
	@ModelAttribute // 如果直接返回对象又没有指定value属性，则默认使用返回对象命名，如 requestObj
	public RequestObj otherModel(String name, int id) {
		System.out.println("do other model method...: " + name + " - " + id);
		RequestObj obj = new RequestObj(id, name);
		return obj;
	}
	
	@ModelAttribute("third") // 使用属性名字
	public RequestObj thirdModel(String name, int id) {
		System.out.println("do third model method...: " + name + " - " + id);
		RequestObj obj = new RequestObj(id, name);
		return obj;
	}

	@RequestMapping("")
	@ResponseBody
	public String index(String age, Model model) {// Model 可以替换为ModelMap 和 ModelAndView， 这几个类的内容会一直在request范围内，在jsp页面里面可以直接引用
		RequestObj obj = (RequestObj) model.asMap().get("obj");
		// obj.setName("new Name!");
		return "-- name: " + obj.getName() + " id: " + obj.getId() + "  age:" + age;
	}

	@RequestMapping("/to-jsp")
	public String index2(@ModelAttribute("obj") RequestObj obj, Model model) {// 直接使用 @ModelAttribute 绑定参数
		//RequestObj obj = (RequestObj) model.asMap().get("obj");
		obj.setName("new Name!");
		return "model-demo";
	}
	
	@RequestMapping("/no-model")
	@ResponseBody
	public String index2() {
		return "no model...";
	}

}
