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
		System.out.println("!!!!!!!!!!!ע��LogFilterע��!!!!!!!!!!!");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse reponse,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("!!!!!!!!!!!LogFilter��ʼ!!!!!!!!!!!");
		chain.doFilter(request, reponse);
		System.out.println("!!!!!!!!!!!LogFilter����!!!!!!!!!!!");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("!!!!!!!!!!!��ʼ��LogFilter��ʼ��!!!!!!!!!!!");

	}

}
