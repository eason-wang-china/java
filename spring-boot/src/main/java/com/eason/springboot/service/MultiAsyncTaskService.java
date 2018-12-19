package com.eason.springboot.service;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class MultiAsyncTaskService {

	// 定义线程池
	private ThreadPoolExecutor taskExecutor;
	private ExecutorService resultExecutor;

	public void doOneTask(DeferredResult<String> result) {
		taskExecutor.submit(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			result.setResult("这是异步执行的结果");
		});
	}

	public void doThreeTask(OnMultiAsyncTaskDone callback) {
		Random random = new Random();
		MultiTaskWork work = new MultiTaskWork();
		work.setNeedDo(10);
		// 创建任务
		for (int i = 0; i < 10; i++) {
			final int flag = i;
			final int neddTime = random.nextInt(5000);
			// 提交异步任务执行
			this.taskExecutor.submit(() -> {
				System.out.println("Thread: " + Thread.currentThread().getName() + " - 执行任务: " + flag + " - need: " + neddTime);
				Thread.sleep(neddTime);
				// 异步处理结果
				this.resultExecutor.execute(() -> {
					System.out.println("Thread: " + Thread.currentThread().getName() + " - 执行任务合并：" + flag);
					work.addHasDone(1);
					if (work.isDone())
						callback.onFinished(work.getEndTime() - work.getStartTime());
				});
				return true;
			});
		}
	}

	@PostConstruct
	void init() {
		taskExecutor = new ThreadPoolExecutor(5, // 核心
				10, // 最大
				30, // 空闲存活时间
				TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5) // 队列大小
		);
		resultExecutor = Executors.newSingleThreadExecutor();
	}

	@PreDestroy
	void destroy() {
		taskExecutor.shutdown();
		resultExecutor.shutdown();
	}

	public interface OnMultiAsyncTaskDone {
		public void onFinished(long totalTime);
	}
}
