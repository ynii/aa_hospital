<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index界面</title>
</head>
<body>
<% request.getAttribute("msg"); %>
------------------index.jsp---------------------------------<br/>
1、${requestScope.msg}<br/>
2、${requestScope.msg}<br/>
3、${pageContext.session.id}<br/>
4、${sessionScope.user.name}<br/>
5、${session.getId()}<br/>
6、<%=session.getId() %><br/>
<table align="center" border="1" cellpadding="0" cellspacing="0" width="200" height="50">
	<tr>
		<td>${cookie.username.value}</td>
		<td>${cookie.password.value}</td>
	</tr>
</table>

<%
 String username="";
String password="";

Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for(Cookie cookie:cookies){
		//out.print(cookie.getName()+" "+URLDecoder.decode(cookie.getValue(),"UTF-8")+" "+cookie.getMaxAge()+" "+cookie.getPath());
		if(cookie.getName().equals("username")){
			username=URLDecoder.decode(cookie.getValue(),"UTF-8");
		}else if(cookie.getName().equals("password")){
			password=URLDecoder.decode(cookie.getValue(),"UTF-8");
		}
	}
} 
%>

<%=username %>
<%=password %>

</body>
</html>
