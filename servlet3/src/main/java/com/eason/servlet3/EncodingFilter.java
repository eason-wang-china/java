package com.eason.servlet3;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/*")
@WebFilter("/servlet/*")
public class EncodingFilter implements Filter {

	// final static Logger LOG = LoggerFactory.getLogger(EncodingFilter.class);

	public void destroy() {
		// LOG.info("销毁......");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("++doFilter++");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// LOG.info("初始化......");
	}

}
/*
l. 以”/’开头和以”/*”结尾的是用来做路径映射的。 

2. 以前缀”*.”开头的是用来做扩展映射的。 

3. “/” 是用来定义default servlet映射的。 

4. 剩下的都是用来定义详细映射的。比如： /aa/bb/cc.action 

5. “/*.action” 错误的配置
 */
