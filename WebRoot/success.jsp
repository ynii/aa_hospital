<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>成功登陆</title>
</head>
<body>
<hr/>

1、<%=request.getAttribute("msg") %><br>
2、<%=session.getId() %><br>
3、<%=session.getAttribute("id") %><br>
4、${sessionScope.id}<br>
<%=session.getAttribute("id") %>
<%out.print(session.getAttribute("id")); %>
5、${pageContext.session.id }

<table align="center" >
	<tr>
		<td><span style="color:orange">用户名</span></td>
		<td>${sessionScope.user.username }</td>
	</tr>
	<tr>
		<td><span style="color:orange">密码</span></td>
		<td>${sessionScope.user.password }</td>
	</tr>
	<tr>
		<td><span style="color:orange">Session.Id</span></td>
		<td>${pageContext.session.id }</td>
	</tr>
</table>
</body>
</html>