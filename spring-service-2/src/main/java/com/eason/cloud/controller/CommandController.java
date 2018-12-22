package com.eason.cloud.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

import com.eason.cloud.domain.User;
import com.eason.cloud.service.UserService;
import com.eason.cloud.service.command.UserCommand;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/cmd")
@Slf4j
public class CommandController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	UserService userService;

	@RequestMapping("/sync")
	public String sync() {

		UserCommand cmd = new UserCommand(restTemplate, 1L);
		User result = cmd.execute();
		return "result: " + result;
	}

	@RequestMapping("/async")
	public String async() throws Exception {

		UserCommand cmd = new UserCommand(restTemplate, 1L);
		Future<User> result = cmd.queue();
		User u = result.get();
		return "result: " + u;
	}

	@RequestMapping("/hystrix")
	public String index_3() {
		log.info("hystrix 的调用者 thread:{}, id:{}", Thread.currentThread().getName() , Thread.currentThread().getId());
		User result = userService.getUserById(1L);
		return "result: " + result;
	}

	@RequestMapping("/hystrix-async")
	public DeferredResult<User> index_4() {
		log.info("hystrix-async 的调用者 thread:{}, id:{}", Thread.currentThread().getName() , Thread.currentThread().getId());
		
		DeferredResult<User> result = new DeferredResult<User>(60000l);// 60秒
		//userService.getUserByIdAsync
		userService.getUserAsync(1L, (User user) -> {
			log.info("result.setResult(user) 的调用者 thread:{}, id:{}", Thread.currentThread().getName() , Thread.currentThread().getId());
			result.setResult(user);
		});
		
		log.info("return result 的调用者 thread:{}, id:{}", Thread.currentThread().getName() , Thread.currentThread().getId());
		return result;
	}
	
	public interface OnAsyncTaskDone {
		public void onFinished(User user);
	}
}
