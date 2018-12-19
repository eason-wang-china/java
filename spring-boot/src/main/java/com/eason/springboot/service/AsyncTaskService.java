package com.eason.springboot.service;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

/**
 * @Async 所修饰的函数不要定义为 static 类型，否则异步调用不会生效
 * 这里通过返回 Future<T> 来返回异步调用的结果，实现异步回调
 **/

@Service
public class AsyncTaskService {

	public Random random = new Random();

	// 任务一
	@Async
	public Future<String> doTaskOne() throws Exception {
		System.out.println("开始做任务一, 线程 ID：" + Thread.currentThread().getName());
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<>("test1 is done!");
	}

	// 任务二
	@Async
	public Future<String> doTaskTwo() throws Exception {
		System.out.println("开始做任务二, 线程 ID：" + Thread.currentThread().getName());
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<>("test2 is done!");
	}

	// 任务三
	@Async
	public Future<String> doTaskThree() throws Exception {
		System.out.println("开始做任务三, 线程 ID：" + Thread.currentThread().getName());
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<>("test3 is done!");
	}

}
