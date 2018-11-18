package com.eason.spring4mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eason.spring4mvc.controller.params.RequestObj;

@Controller
@RequestMapping("/params")
public class ParamsDemo {

	@RequestMapping("/{str}") // 路径参数
	@ResponseBody
	public String index(@PathVariable String str, HttpServletRequest request){
		return "-- url: " + request.getRequestURL() + " can access! str: " + str;
	}
	
//	@RequestMapping("/") // '/params/?id=123'	注意 'params/id=123' 是不可以的，不能少了?，否则是路径匹配，上面这个方法的规则！
//	@RequestMapping("")  // '/params?id=123'	普通参数
	@RequestMapping({"", "/"})
	@ResponseBody 
	public String index2(Long id, HttpServletRequest request){
		return "++ url: " + request.getRequestURL() + " can access! id: " + id;
	}
	
	@RequestMapping("/obj") //	对象参数会自动封装到对象中，对于不在对象里面的继续与方法中的参数对应
	@ResponseBody 
	public String index3(RequestObj obj, String token, HttpServletRequest request){
		return "?? url: " + request.getRequestURL() + " can access! obj: " + obj +" --token=" + token;
	}
	
	@RequestMapping("/request-param")
	@ResponseBody 
	public String index4(
			@RequestParam(name="my-id", defaultValue="0") Long id, 
			@RequestParam(required=true) String name){ // name参数必须提供，否则报错
		return "?? name: " + name + " id: " + id;
	}
}
