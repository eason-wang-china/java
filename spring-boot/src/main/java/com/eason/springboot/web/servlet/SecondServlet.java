package com.eason.springboot.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eason.springboot.config.ProjectSettings;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @WebServlet("/servlet/second") 去掉这个注解，通过 spring 来创建
public class SecondServlet extends HttpServlet {
	
	// @Resource 不会再起作用
	private ProjectSettings settings;
	
	public void setProjectSettings(ProjectSettings settings) {
		this.settings = settings;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		log.info("hello");

		PrintWriter out = response.getWriter();
		out.print("Second servlet<br>");
		out.print(settings.toString());
		out.flush();
		out.close();
	}

	@Override
	public void destroy() {
		log.info("do destroy method of SecondServlet...");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		log.info("do init method of SecondServlet!!!");
		super.init();
	}
}