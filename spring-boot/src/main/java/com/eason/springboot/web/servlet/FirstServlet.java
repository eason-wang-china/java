package com.eason.springboot.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eason.springboot.config.ProjectSettings;

@WebServlet("/servlet/first")
public class FirstServlet extends HttpServlet {
	
	final static Logger LOG = LoggerFactory.getLogger(FirstServlet.class);
	
	@Resource
	private ProjectSettings settings;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LOG.info("hello");

		PrintWriter out = response.getWriter();
		out.print("first servlet<br>");
		out.print(settings.toString());
		out.flush();
		out.close();
	}

	@Override
	public void destroy() {
		LOG.info("do destroy method of FirstServlet...");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		LOG.info("do init method of FirstServlet!!!");
		super.init();
	}
}