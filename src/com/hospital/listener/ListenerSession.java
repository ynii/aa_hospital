package com.hospital.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListenerSession implements HttpSessionListener,HttpSessionAttributeListener{

	
	//预处理程序 当session 被创建时候调用
	@Override
	public void sessionCreated(HttpSessionEvent es) {
		System.out.println("。。。。sessionCreated创建。。。"+es.getSession().getId());
		ServletContext application = es.getSession().getServletContext();
		Integer c = (Integer)application.getAttribute("count");
		if(c==null){
			application.setAttribute("count", 1);
		}else{
			application.setAttribute("count", c+1);
		}
	}

	//预处理程序，当 session 被注销时候调用
	@Override
	public void sessionDestroyed(HttpSessionEvent es) {
		System.out.println("++++sessionDestroy销毁+++++++"+es.getSession().getId());
		ServletContext application = es.getSession().getServletContext();
		Integer c = (Integer)application.getAttribute("count");
		if(c!=null){
		application.setAttribute("count",c-1);
		}
	}

	//预处理程序，当session 添加属性时候,被调用
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//预处理程序，当session 移除属性时候，被调用
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//预处理程序 ，当session 修改属性的时候， 被调用
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}
