package com.inspur.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inspur.dao.EmpDao;
import com.inspur.entity.Emp;

public class EmpServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//根据提交的方法名将请求分发到对应的方法上
		//检索所有员工信息
		if("queryAllEmp".equals(request.getParameter("param"))){
			queryAllEmp(request,response);
		//添加新员工
		}else if("insertEmp".equals(request.getParameter("param"))){
			insertEmp(request, response);
		//修改员工
		}else if("updateEmp".equals(request.getParameter("param"))){
			updateEmp(request, response);
		}
		
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   doPost(request,response);
	}
	
	/**
	 * 检索所有员工信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryAllEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  EmpDao empDao=new EmpDao();
	  List<Emp> empList=empDao.queryAllEmp();
      
	  HttpSession session=request.getSession();
      session.setAttribute("empList", empList);
      response.sendRedirect(request.getContextPath()+"/emp/searchEmp.jsp");
	}
	
	public void insertEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  
	}
	
	public void updateEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  
	}

}
