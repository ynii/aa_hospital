package com.hospital.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListenerSession implements HttpSessionListener,HttpSessionAttributeListener{

	
	//Ԥ������� ��session ������ʱ�����
	@Override
	public void sessionCreated(HttpSessionEvent es) {
		System.out.println("��������sessionCreated����������"+es.getSession().getId());
		ServletContext application = es.getSession().getServletContext();
		Integer c = (Integer)application.getAttribute("count");
		if(c==null){
			application.setAttribute("count", 1);
		}else{
			application.setAttribute("count", c+1);
		}
	}

	//Ԥ������򣬵� session ��ע��ʱ�����
	@Override
	public void sessionDestroyed(HttpSessionEvent es) {
		System.out.println("++++sessionDestroy����+++++++"+es.getSession().getId());
		ServletContext application = es.getSession().getServletContext();
		Integer c = (Integer)application.getAttribute("count");
		if(c!=null){
		application.setAttribute("count",c-1);
		}
	}

	//Ԥ������򣬵�session �������ʱ��,������
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//Ԥ������򣬵�session �Ƴ�����ʱ�򣬱�����
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//Ԥ������� ����session �޸����Ե�ʱ�� ������
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}
