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
		//1.ȡ��½��Ϣ
		String loginId=request.getParameter("loginId");
		String loginPass=request.getParameter("loginPass");
		HttpSession session=request.getSession();
		
		//2.����ҵ���߼�����
		LoginDao loginDao=new LoginDao();
		boolean flag=loginDao.login(loginId, loginPass);
		
		//3.����ҵ���߼�������н���ת��
		if(flag){
			session.setAttribute("loginId", loginId);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			request.setAttribute("error","��½ID���������");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
