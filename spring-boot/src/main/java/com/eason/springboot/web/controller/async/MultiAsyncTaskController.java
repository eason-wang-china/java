package com.eason.springboot.web.controller.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.eason.springboot.service.MultiAsyncTaskService;

@RestController
@RequestMapping("/multi-async")
public class MultiAsyncTaskController {

	@Autowired
	private MultiAsyncTaskService service;

	@RequestMapping("/do-1-task")
	public DeferredResult<String> doTask_1() throws Exception {
		DeferredResult<String> result = new DeferredResult<String>(60000l);// 60秒

		service.doOneTask(result);

		return result;
	}

	@RequestMapping("/do-3-task")
	public DeferredResult<String> doTask_3() throws Exception {
		DeferredResult<String> result = new DeferredResult<String>(60000l);// 60秒

		service.doThreeTask((long totalTime) -> {
			result.setResult("任务执行完成！！！总共花费： " + totalTime / 1000 + "s");
		});

		return result;
	}

}
