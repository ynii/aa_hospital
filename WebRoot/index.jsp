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
------------------index.jsp---------------------------------
${requestScope.msg}<br/>
${requestScope.msg}
${pageContext.session.id}<br/>
${sessionScope.id}<br/>
${session.getid()}<br/>
</body>
</html>