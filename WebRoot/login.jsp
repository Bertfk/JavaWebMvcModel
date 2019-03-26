<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登陆界面</title>
</head>

<body>
<!-- 显示错误提示 -->
<font color="red">
 ${error}
</font>
	<form action="loginServlet" method="post">
		<table>
			<tr>
				<td>登陆ID:<input type="text" name="loginId" maxlength="10"
					size="20px">
				</td>
				
			</tr>
			<tr>
				<td>密码:<input type="password" name="loginPass"
					maxlength="10" size="20px">
				</td>
				
			</tr>
			<tr>
			  <td><input type="submit" name="submit" value="登陆"><input type="reset" name="reset" value="取消"></td>
			</tr>
		</table>
	</form>
</body>
</html>
