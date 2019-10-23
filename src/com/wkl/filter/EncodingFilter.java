package com.wkl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		chain.doFilter(req, resp);
		
		
	}

	public EncodingFilter() {
		System.out.println("过滤器构造");
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器初始化");// TODO 自动生成的方法存根
		Filter.super.init(filterConfig);
	}
	@Override
	public void destroy() {
		System.out.println("过滤器销毁");// TODO 自动生成的方法存根
		Filter.super.destroy();
	}

}
