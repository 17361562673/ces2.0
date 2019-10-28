<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<c:set var="oPath" value="http://localhost:8080/ces2_0_war_exploded/"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <style type="text/css">
        .style1{
            font-size: 14px;
            color: #3338ff;
        }
        .tableb{border-collapse: collapse;
            width: 100%;
        }
        .tableb th,.tableb td{
            border: 1px solid #56dbff;
            height: 20px;
            text-align: center;
        }
        th{
            background-color: #4be6ff;
        }
    </style>
</head>
<body>
<table style="background-color: #d1faff;width: 100%;height: 15px">
    <tr>
        <td style="padding-right: 30px;text-align: right"><a href="${cpath}/tab/toAdd.jsp"><img src="${cpath}/tab/images/22.gif">添加</a></td>
    </tr>
</table>
<table class="style1 tableb">
    <tr>
        <th>用户名</th>
        <th>头像</th>
        <th>密码</th>
        <th>性别</th>
        <th>生日</th>
        <th>住址</th>
        <th>工资</th>
        <th>操作</th>
        <th>${uList.size()}</th>
    </tr>
    <c:forEach items="${uList}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>
                <img src="${oPath}${user.pic}" width="150" height="100">
            </td>
            <td>${user.password}</td>
            <td>
                <c:if test="${user.gender==1}">男</c:if>
                <c:if test="${user.gender==0}">女</c:if>
            </td>
            <td>${user.birthday}</td>
            <td>${user.address}</td>
            <td>${user.sal}</td>
            <td><a href="${cpath}/single?user_id=${user.user_id}"><img src="${cpath}/tab/images/edt.gif">编辑</a>
                <a href="${cpath}/delete?delId=${user.user_id}"><img src="${cpath}/tab/images/del.gif">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>