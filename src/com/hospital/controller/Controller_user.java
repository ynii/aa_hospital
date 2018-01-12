package com.hospital.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
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
		System.out.println("--controller层--aaa-");
		String m = request.getParameter("m");
		switch (m) {
		case "login":  //登录
			login(request,response);
			break;
		case "logout": //注销
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
		//响应数据的类型
		response.setContentType("image/jpg");
		
		CreatImage c = new CreatImage();
		//过去一个图片
		BufferedImage image = c.getImage();
		String trueCode = c.getCode();
		//把CODE输入到session中；
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
		
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		String ism = request.getParameter("ism");
		Model_user user = service_user.findUserByName(username);
		String msg = null;
		if(user==null){
			msg = "用户名不存在，请重新登录";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			if(user.getPassword().equals(password)){
				msg = "用户名密码正确，登陆成功";
				request.setAttribute("msg", msg);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				request.getRequestDispatcher("success.jsp").forward(request, response);//a.jsp是登录好的界面
			}else{
				msg = "密码不正确，请重新输入";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("index.jsp").forward(request,response);
				
			}
			
		}
		
		user = null;
	}

}
