<%--
  Created by IntelliJ IDEA.
  User: 17361562673
  Date: 2019/10/8
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>用户添加</title>
    <style>
        .tableb{border-collapse: collapse;
            width: 100%;
        }
        .tableb td{
            border: 1px solid #56dbff;
            height: 20px;
        }
    </style>
</head>
<body>
<span>用户管理 > 用户添加</span>
<hr>
<form action="${cpath}/add" method="post" enctype="multipart/form-data">
    <table class="tableb">
        <tr>
            <td style="text-align: center;background-color: #c3f7ff">用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td style="text-align: center;background-color: #c3f7ff">头像</td>
            <td><input type="file" name="pic"></td>
        </tr>
        <tr>
            <td style="text-align: center;background-color: #c3f7ff">密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td style="text-align: center;background-color: #c3f7ff">性别</td>
            <td><input type="radio" name="gender" value="1" checked>男&nbsp;&nbsp;&nbsp;
                <input type="radio" name="gender" value="0">女
            </td>
        </tr>
        <tr>
            <td style="text-align: center;background-color:#c3f7ff">生日</td>
            <td><input type="text" name="birthday"></td>
        </tr>
        <tr>
            <td style="text-align: center;background-color: #c3f7ff">住址</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td style="text-align: center;background-color: #c3f7ff">工资</td>
            <td><input type="text" name="sal"></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="保存"></td>
        </tr>
    </table>
</form>
</body>
</html>
