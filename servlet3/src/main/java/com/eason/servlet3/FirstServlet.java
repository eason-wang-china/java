package com.eason.servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/first")
public class FirstServlet extends HttpServlet {

	// final static Logger LOG = LoggerFactory.getLogger(FirstServlet.class);

	private static final long serialVersionUID = 6833688147345340845L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// LOG.info("hello");

		PrintWriter out = response.getWriter();
		out.print("first servlet");
		out.flush();
		out.close();
		// request.getRequestDispatcher("/index.jsp").forward(request, response);
		// this.getServletConfig();
		// this.getServletContext();
	}

	@Override
	public void destroy() {
		System.out.println("do destroy method of FirstServlet...");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("do init method of FirstServlet!!!");
		super.init();
	}

}