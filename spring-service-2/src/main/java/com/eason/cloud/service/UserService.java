package com.eason.cloud.service;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eason.cloud.controller.CommandController.OnAsyncTaskDone;
import com.eason.cloud.domain.User;
import com.eason.cloud.service.command.UserCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallback", commandKey="getUserById", groupKey="UserGroup", threadPoolKey="getUserByIdThread")
	public User getUserById(Long id) {
		log.info("getUserById 的调用者 thread:{}, id:{}", Thread.currentThread().getName() , Thread.currentThread().getId());
		User result = restTemplate.getForObject("http://spring-cloud-service-1/response/get-user?id={1}", User.class, id);
		return result;
	}

	@HystrixCommand(fallbackMethod = "fallback")
	public Future<User> getUserByIdAsync(Long id, OnAsyncTaskDone onAsyncTaskDone) {
		return new AsyncResult<User>() {
			@Override
			public User invoke() {
				log.info("getUserByIdAsync()的调用者 thread:{}, id:{}", Thread.currentThread().getName() , Thread.currentThread().getId());
				User user = restTemplate.getForObject("http://spring-cloud-service-1/response/get-user?id={1}", User.class, id);
				onAsyncTaskDone.onFinished(user);
				return user;
			}
		};
	}
	
	@Async
	public void getUserAsync(Long id, OnAsyncTaskDone onAsyncTaskDone) {
		log.info("getUserByIdAsync()的调用者 thread:{}, id:{}", Thread.currentThread().getName() , Thread.currentThread().getId());
		UserCommand cmd = new UserCommand(restTemplate, 1L);
		User result = cmd.execute();
		onAsyncTaskDone.onFinished(result);
	}

	// 服务降级，返回一个静态结果或者缓存的结果
	public User fallback(Long id) {
		return new User("服务端错误，请稍后再尝试！或者这儿返回一个缓存的信息。", 36, "未知", 001);
	}
	
	public User fallback(Long id, OnAsyncTaskDone onAsyncTaskDone) {
		return new User("服务端错误，请稍后再尝试！或者这儿返回一个缓存的信息。", 36, "未知", 001);
	}
}
