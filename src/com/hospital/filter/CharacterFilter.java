package com.hospital.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("++++++++注销CharacterFilter注销++++++++");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("ooooooooo字符集过滤器开始ooooooooo");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("ooooooooo字符集过滤器结束ooooooooo");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("ooooooooo初始化CharacterFilter初始化ooooooooo");

	}

}
