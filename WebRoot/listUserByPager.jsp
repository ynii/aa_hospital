<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
------------------------------------------------<br/>
*************************************************<br/>
${requestScope.pager.currentPage };<br/>
${requestScope.pager.datas }<br/>
+++++++++++++++++++++++++++++++++++++++++++++<br/>
<table border="1" cellspacing="0" cellpadding="0" width="80%" height="" align="center">
<c:forEach var="user" items="${requestScope.pager.datas}">
<tr>
	<td>${user.id }</td>
	<td>${user.username}</td>
	<td>${user.password}</td>
	<td>${user.timestamp}</td>
	<%-- <td><a href="user?m=deleteUser&id=${user.id }">删除</a></td>  --%>
	<td><input type="button" value="删除" onclick="del(${user.id})"/> </td> 
	<%-- <td><a href="user?m=findUserById&id=${user.id } ">修改</a></td>   --%>
</tr>
</c:forEach>

<tr>
<td colspan="7" align="right">

<a href="user?m=listUserByPager&currentPage=1">第一页</a>
<a href="user?m=listUserByPager&currentPage=${requestScope.pager.previousPage}">上一页</a>

<c:forEach var="i" begin="${requestScope.pager.startPage}" end="${requestScope.pager.endPage }">
<c:if test="${requestScope.pager.currentPage eq i}">
<a href="user?m=listUserByPager&currentPage=${i}"><font color="red">${i}</font></a>
</c:if>
<c:if test="${requestScope.pager.currentPage ne i}">
<a href="user?m=listUserByPager&currentPage=${i}">${i}</a>
</c:if>
</c:forEach>

<a href="user?m=listUserByPager&currentPage=${requestScope.pager.nextPage}">下一页</a>
<a href="user?m=listUserByPager&currenyPage=${requestScope.pager.totalPages}">最后页</a>
<font color="red">${requestScope.pager.currentPage}</font>/${requestScope.pager.totalPages}
</td>
</tr>
</table>

<script type="text/javascript">
window.onload=function(){
	del(id);
}
function del(id){
	var a =window.confirm("你确定要删除吗？");
	if(a){
		location.href="user?m=delete&id="+id;
	}
}
</script>
</body>
</html>