<%@ page language="java" import="java.util.*,com.inspur.entity.Emp" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
  
  <body>
 
  <hr>
	<p>显示员工信息</p>
	<table border="1">
	  <c:forEach var="emp" items="${sessionScope.empList}">
	    <tr>
	      <td>${emp.empno }</td>
	      <td>${emp.ename }</td>
	      <td>${emp.job }</td>
	      <td>${emp.sal }</td>
	      <td>${emp.comm }</td>
	    </tr>
	  </c:forEach>
	</table>
  </body>
</html>
