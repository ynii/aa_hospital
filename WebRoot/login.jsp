<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录界面</title>
</head>
<body>
<script type="text/javascript">
	/* window.onload=function(){
		document.getElementById("a").value=decodeURIComponent('${cookie.username.value}');
		document.getElementById("b").value=decodeURIComponent('${cookie.password.value}');
	} */
</script>
 <%
String username = null;
String password = null;
Cookie[] cookies = request.getCookies();
for(Cookie cookie:cookies){
	if(cookie.getName().equals("username")){
		username = URLDecoder.decode(cookie.getValue(), "utf-8");
	} else if(cookie.getName().equals("password")){
		password = URLDecoder.decode(cookie.getValue(), "utf-8");
	}
	
}
%> 

<h1 align="center">用户登录界面</h1>
<form action="user"  method="post" >
<input type="hidden" name="m" value="login"/>
<table align="center">
	<tr>
		<td>用户名</td>
		<td><input id ="a" type="text" name="username" value="<%=username%>"/></td>
	</tr>
	<tr>
		<td>密码吗</td>
		<td><input id ="b" type="text" name="password" value="<%=password %>" /></td>
	</tr>
	<tr>
		<td>验证码</td>
		<td><input type="text" name="code"/><img onclick="this.src='user?m=creatImage&a='+Math.random()" src="user?m=creatImage" /></td>
	</tr>
	<tr>
		<td><input type="checkbox" name="ism" value="1"/></td>
		<td>记住密码</td>
	</tr>
	<tr>
		<td><input type="submit" name="submit" value="登录"/></td>
		<td><input type="reset"  name="reste"  value="重置"/></td>
	</tr>
</table>
</form>
</body>
</html>