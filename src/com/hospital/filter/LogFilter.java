package com.hospital.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("!!!!!!!!!!!注销LogFilter注销!!!!!!!!!!!");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse reponse,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("!!!!!!!!!!!LogFilter开始!!!!!!!!!!!");
		chain.doFilter(request, reponse);
		System.out.println("!!!!!!!!!!!LogFilter结束!!!!!!!!!!!");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("!!!!!!!!!!!初始化LogFilter初始化!!!!!!!!!!!");

	}

}
