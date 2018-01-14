package com.hospital.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.model.Model_user;
import com.hospital.pulbic.CreatImage;
import com.hospital.service.Service_user;

public class Controller_user extends HttpServlet{
	Service_user service_user = new Service_user();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--controller��--aaa-");
		String m = request.getParameter("m");
		switch (m) {
		case "login":  //��¼
			login(request,response);
			break;
		case "logout": //ע��
			logout(request,response);
			break;
		case "creatImage":
			creatImage(request,response);
			break;
		default:
			break;
		}
	}
	
	private void creatImage(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("*****creatImage******");
		//��Ӧ���ݵ�����
		response.setContentType("image/jpg");
		
		CreatImage c = new CreatImage();
		//��ȥһ��ͼƬ
		BufferedImage image = c.getImage();
		String trueCode = c.getCode();
		//��CODE���뵽session�У�
		request.getSession().setAttribute("trueCode", trueCode);
		
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			ImageIO.write(image, "JPEG", os);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		System.out.println(username);
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		String ism = request.getParameter("ism");
		
		Model_user user = service_user.findUserByName(username);
		
		System.out.println(user);
		String msg = null;
		if(user==null){
			msg = "�û��������ڣ������µ�¼";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			if(user.getPassword().equals(password)){
				msg = "�û���������ȷ����½�ɹ�";
				request.setAttribute("msg", msg);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				//Cookie �������
				Cookie c_username = new Cookie("username", URLEncoder.encode(user.getusername(),"utf-8"));
				Cookie c_password = new Cookie("password", URLEncoder.encode(user.getPassword(),"utf-8"));
				if("1".equals(ism)){
					c_username.setMaxAge(60*10);
					c_password.setMaxAge(60*10);
				}else{
					c_username.setMaxAge(0);
					c_password.setMaxAge(0);
				}
				response.addCookie(c_username);
				response.addCookie(c_password);
				request.getRequestDispatcher("success.jsp").forward(request, response);//a.jsp�ǵ�¼�õĽ���
				//response.sendRedirect("success.jsp");
			}else{
				msg = "���벻��ȷ������������";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("index.jsp").forward(request,response);
				
			}
			
		}
		
		user = null;
	}

}
