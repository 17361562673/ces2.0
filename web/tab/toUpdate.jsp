<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

a {
	text-decoration: none;
}

body{
	font-size:12px; 
	color: #033D61;
}


.tableb {
	border-collapse: collapse;
	width: 60%;
}


.tableb th, .tableb td{
	border: 1px solid #33A9D0;
	height: 20px;
}
th{
	background-color: #E7F2FA;
}
</style>
</head>

<body>
<span>当前位置：用户管理>>用户修改</span>
<hr>
<form action="${cpath}/update" method="post" enctype="multipart/form-data">
<input type="hidden" value="${user.user_id }" name="userId">
<table class="tableb" align="center">
	<tr>
		<td style="text-align: center;background-color: #E7F2FA;">用户名：</td>
		<td><input type="text" name="username" value="${user.username }"></td>
	</tr>
	<tr>
		<td style="text-align: center;background-color: #E7F2FA;">头像：</td>
		<td><input type="file" name="pic" value="${user.pic }"></td>
	</tr>
	<tr>
		<td style="text-align: center;background-color: #E7F2FA;">密码：</td>
		<td><input type="password" name="password" value="${user.password }"></td>
	</tr>
	<tr>
		<td style="text-align: center;background-color: #E7F2FA;">性别：</td>
		<td>
			<input type="radio" name="gender" <c:if test="${user.gender == 1 }">checked</c:if> value="1" >男&nbsp;
			<input type="radio" name="gender" <c:if test="${user.gender == 0 }">checked</c:if> value="0" >女
		</td>
	</tr>
	<tr>
		<td style="text-align: center;background-color: #E7F2FA;">生日：</td>
		<td><input type="text" name="birthday" value="${user.birthday }"></td>
	</tr>
	<tr>
		<td style="text-align: center;background-color: #E7F2FA;">地址：</td>
		<td><input type="text" name="address" value="${user.address }"></td>
	</tr>
	<tr>
		<td style="text-align: center;background-color: #E7F2FA;">薪资：</td>
		<td><input type="text" name="sal" value="${user.sal }"></td>
	</tr>
	<tr >
		<td colspan="2" align="right">
			<input type="submit" value="修改">
		</td>
	</tr>
</table>
</form>
</body>
</html>