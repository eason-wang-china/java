package com.eason.cloud.service.command;

import org.springframework.web.client.RestTemplate;

import com.eason.cloud.domain.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserCommand extends HystrixCommand<User> {

	private RestTemplate restTemplate;
	private Long id;

	public UserCommand(RestTemplate restTemplate, Long id) {
		super(Setter.withGroupKey(
				HystrixCommandGroupKey.Factory.asKey("UserGroup"))
				.andCommandKey(HystrixCommandKey.Factory.asKey("getUserById"))
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("getUserByIdThread"))); // 设置线程池的分组
		this.restTemplate = restTemplate;
		this.id = id;
	}

	@Override
	protected User run() throws Exception {
		log.info("UserCommand run()的调用者 thread:{}, id:{}", Thread.currentThread().getName() , Thread.currentThread().getId());
		return this.restTemplate.getForObject("http://spring-cloud-service-1/response/get-user?id={1}", User.class, id);
	}
	
	@Override
	protected User getFallback() {
		return new User("服务端错误，请稍后再尝试！或者这儿返回一个缓存的信息。", 36, "未知", 001);
	}

}
