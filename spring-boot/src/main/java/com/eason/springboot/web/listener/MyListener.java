package com.eason.springboot.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class MyListener implements ServletContextListener, ServletRequestListener, HttpSessionIdListener, HttpSessionListener, 
		ServletRequestAttributeListener, HttpSessionAttributeListener, ServletContextAttributeListener {

	final static Logger LOG = LoggerFactory.getLogger(ServletContextListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LOG.info("MyServletContextListener 销毁...");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOG.info("MyServletContextListener 初始化, server info: " + sce.getServletContext().getServerInfo());
	}

	@Override
	public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
		// TODO Auto-generated method stub
		LOG.info("Session 的 ID 发生了变化，之前的Session ID 是：" + oldSessionId + " , 新的session ID 是：" + event.getSession().getId());
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		LOG.info("requestDestroyed ...");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		LOG.info("requestInitialized ...");
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		LOG.info("Session 创建了， Session ID 是： " + se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		LOG.info("Session 销毁了， Session ID 是： " + se.getSession().getId());
		
	}
}