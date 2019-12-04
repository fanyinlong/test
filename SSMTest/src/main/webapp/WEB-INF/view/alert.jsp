<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="alert">
		<table border="1">
			<c:if test="${!empty user.id}">
			<tr>
				<td>ID</td>
				<td>
					<input type="text" name="id" readonly="readonly" value="${user.id}">
				</td>
			</tr>
			</c:if>	
			<tr>
				<td>用户名</td>
				<td>
					<input type="text" name="username" value="${user.username}">
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td>
					<input type="text" name="password" value="${user.password}">
				</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>
					<input type="text" name="name" value="${user.name}">
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td>
					<input type="text" name="phone" value="${user.phone}">
				</td>
			</tr>
		</table>
		<input type="submit" value="提交">
		</form>
	</body>
</html>