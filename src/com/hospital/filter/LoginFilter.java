package com.hospital.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("********注销LoginFilter注销********");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("*******LoginFilter*******");
		chain.doFilter(request, response);
		System.out.println("********LoginFilter******");
	
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("********初始化LoginFilter初始化********");
		
	}

}
