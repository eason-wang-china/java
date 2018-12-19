package com.eason.springboot.web.controller.async;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eason.springboot.service.AsyncTaskService;
/**
 *  这个例子只是演示如何使用异步方法执行任务，把一个组件（AsyncTaskService）的方法（@Async）标注为异步方法，在调用该方法的时候，会自动提交给线程池异步处理；
 *  线程池需要在实现 AsyncConfigurer 接口的类（AsyncTaskConfigurer）里面配置；
 *  需要在 Application 类上面 加 @EnableAsync 注解，启动异步支持；
 */
@RestController
@RequestMapping("/async")
public class AsyncTaskController {

	@Autowired
	private AsyncTaskService task;

	@RequestMapping("/do-3-task")
	public String task1() throws Exception {
		
		Future<String> test1 = task.doTaskOne();
		Future<String> test2 = task.doTaskTwo();
		Future<String> test3 = task.doTaskThree();

		while (true) {
			if (test1.isDone())
				System.out.println("====================test1 is done=========================");

			if (test2.isDone())
				System.out.println("====================test2 is done=========================");

			if (test3.isDone())
				System.out.println("====================test3 is done=========================");

			if (test1.isDone() && test2.isDone() && test3.isDone())
				break;

			Thread.sleep(1000);
		}

		return "task all finshed!";
	}

}
