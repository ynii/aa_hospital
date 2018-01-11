package com.hospital.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.model.Model_user;
import com.hospital.service.Service_user;

public class AotuLoginFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("-----------注销AotuLoginFilter注销-------");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String username = "";
		String password = "";
		HttpServletRequest req = (HttpServletRequest)request ;
		HttpServletResponse resp = (HttpServletResponse)response ;
		Cookie[] cookies = req.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				cookie.getName();	cookie.getValue();
				if(cookie.getName().equals("username")){
					username = URLDecoder.decode(cookie.getValue(),"UTF-8");
				}else if(cookie.getName().equals("password")){
					password = URLDecoder.decode(cookie.getValue(),"UTF-8");
				}
			}
			Service_user service_user = new Service_user();
			//判断cookie中是否保存用户名和密码
			if(username!=null&&!username.equals("")){
			Model_user user = service_user.findUserByName(username);
			if(user!=null&&user.getPassword().equals("password")){
				req.getSession().setAttribute("user", user);
			}
			}
		}
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("-----------初始化AotuLoginFilter初始化-----------");
		
	}

}
