package com.hospital.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.hospital.model.Model_user;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("********ע��LoginFilterע��********");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("*******LoginFilter*******");
		chain.doFilter(request, response);
		System.out.println("********LoginFilter******");
		
		/*	StringBuffer url=req.getRequestURL();
			System.out.println(url);
			//http://localhost:8080/EL_JSTL20180105/login.jsp
			
			String uri=url.substring(url.lastIndexOf("/")+1);
			System.out.println("----------------------");
			System.out.println(uri);
			String m=req.getParameter("m");
			if(uri.equals("untitled.bmp")||uri.equals("")||uri.equals("login.jsp")||(uri.equals("user")&&m.equals("login"))||(uri.equals("user")&&m.equals("createImage"))){
				//�����ʵ�¼ҳ����ߵ�¼ʱ��������
				System.out.println("++++++ccccc++++++");
				chain.doFilter(req, response);
				System.out.println("-----cccccc-----");
			}else{
				//�ж��û��Ƿ��¼�ˣ�
				HttpSession session=req.getSession();
				Model_user user=(User) session.getAttribute("user");
				if(user!=null){
					//�����¼�˾ͼ�������Ŀ����Դ
					System.out.println("++++++dddddd++++++");
					chain.doFilter(req, response);
					System.out.println("-----ddddddd-----");
				}else{
					//���û�е�¼����Ӧ����¼ҳ��
					//��Ӧ����¼ҳ�棬������ʾ�û��ȵ�¼
					String msg="���ȵ�¼";
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("login.jsp").forward(req, response);
				}
			}
		}*/
	
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("********��ʼ��LoginFilter��ʼ��********");
		
	}

}
