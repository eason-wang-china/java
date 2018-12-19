package com.eason.springboot.web.controller.push;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/push")
public class SseController {

	@RequestMapping(value = {"/", ""}, produces = "text/event-stream;charset=UTF-8") // 1
	public @ResponseBody String push() {
		
		log.info("sse request...");
		
		Random r = new Random();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "data:Testing 1,2,3" + r.nextInt() + "\n\n";
	}

}
