package com.eason.springboot.web.controller.redis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/session")
@Slf4j
public class SessionController {

	@RequestMapping("/set")
	public Map<String, Object> firstResp(HttpServletRequest request, HttpSession session) {
		
		log.info("session id :{}", session.getId());
		
		session.setAttribute("request-url", request.getRequestURL());
		session.setAttribute("message", "我是中国人");
		session.setAttribute("session-id", session.getId());
		
		Map<String, Object> map = new HashMap<>();
		map.put("request-url", session.getAttribute("request-url"));
		map.put("message", session.getAttribute("message"));
		map.put("session-id", session.getAttribute("session-id"));
		
		session.setAttribute("session-info", map);
		
		log.info(Arrays.toString(request.getCookies()));
		
		return map;
	}

	@RequestMapping("/get")
	public Object sessions(HttpServletRequest request, HttpSession session) {
		
		log.info("session id :{}", session.getId());
		
		Map<String, Object> map = new HashMap<>();
		map.put("request-url", session.getAttribute("request-url"));
		map.put("message", session.getAttribute("message"));
		map.put("session-id", session.getAttribute("session-id"));
		map.put("session-info", session.getAttribute("session-info"));
		
		for(Cookie c : request.getCookies())
			log.info("cookie - name:{}, value:{}", c.getName(), c.getValue());
		
		return map;
	}

}
