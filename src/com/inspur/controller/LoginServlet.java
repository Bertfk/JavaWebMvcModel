package com.inspur.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inspur.dao.LoginDao;

public class LoginServlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.取登陆信息
		String loginId=request.getParameter("loginId");
		String loginPass=request.getParameter("loginPass");
		HttpSession session=request.getSession();
		
		//2.调用业务逻辑处理
		LoginDao loginDao=new LoginDao();
		boolean flag=loginDao.login(loginId, loginPass);
		
		//3.根据业务逻辑结果进行界面转向
		if(flag){
			session.setAttribute("loginId", loginId);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			request.setAttribute("error","登陆ID或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
