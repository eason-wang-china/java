package com.eason.controller.demo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eason.controller.params.RequestObj;

@Controller
@RequestMapping("/response")
public class ResponseController {

	@RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
	@ResponseBody 
	public String index(RequestObj obj, HttpServletRequest request){
		return "{\"name\":\"" + obj.getName() + "\", \"id\":" + obj.getId() + "}";
	}
	
	@RequestMapping(value = "/obj-2", produces = "application/json;charset=UTF-8")
	@ResponseBody  // 对于 json 返回值可以是一个对象
	public RequestObj index2(RequestObj obj, HttpServletRequest request){
		return obj;
	}
	
	@RequestMapping(value = "/obj-3", produces = "application/json;charset=UTF-8")
	@ResponseBody // 对于 json 返回值也可以是一个 Map
	public Map<String, Object> index3(RequestObj obj, HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("my-id", obj.getId());
		map.put("my-name", obj.getName());
		return map;
	}
}
