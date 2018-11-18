package com.eason.spring4mvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eason.spring4mvc.controller.params.RequestObj;

@RestController	// 可以不用使用 @ResponseBody 了
@RequestMapping("/rest")
public class RestDemo {

	@RequestMapping("") //	默认返回xml，和使用的jackson包有关系，等同于 produces = "application/xml;charset=UTF-8"
	public RequestObj index() {
		return new RequestObj(13, "eason");
	}
	
	@RequestMapping(value = "/2", produces = "application/json;charset=UTF-8") //	返回json
	public RequestObj index2() {
		return new RequestObj(13, "eason");
	}
	
	@RequestMapping(value = "/3", produces = "application/xml;charset=UTF-8")//	返回xml
	public Map<String, Object> index3() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("my-id", 134);
		map.put("my-name", "haha");
		return map;
	}
}
