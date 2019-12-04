<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>展示页面</title>
	</head>
	<body>
		<input type="button" onclick="add()"value="添加">
		<form action="like" method="post">
			<input type="text" name="putVal">
			<select name="listing">
			  <option value ="id" >ID查询</option>
			  <option value ="username" >用户名查询</option>
			  <option value ="name" >姓名查询</option>
			  <option value="phone" >电话号码查询</option>
			</select>
				<input type="submit" value="查询" > 
		</form>
		<table border="1">
			<tr>
				<td>ID</td>
				<td>用户名</td>
				<td>密码</td>
				<td>姓名</td>
				<td>电话</td>
				<td>操作列表</td>
			</tr>
			<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.id}</td>
				<td>${list.username }</td>
				<td>${list.password }</td>
				<td>${list.name }</td>
				<td>${list.phone }</td>
				<td>
					<input type="button" onclick="del(${list.id})"value="删除">
					<input type="button" onclick="update(${list.id})"value="修改">
				</td>
			</tr>
			</c:forEach>
		</table>
		共${count}条数据,共${Math.ceil(count/2)}页
		<c:forEach var="page" begin="1" end="${Math.ceil(count/2)}">
			<a href="show?page=${page}">第${page}页</a>
		</c:forEach>
		<br>
		<button type="button" onclick="pre()">上一页</button>
		<input type="button" value="下一页" onclick="next(${Math.ceil(count/2)})">
	</body>
	<script type="text/javascript">
		function del(a) {
			location.href="del?id="+a;
		}
		function update(b) {
			 location.href="update?id="+b; 
		}
		function add() {
			location.href="add";
		}
		
		function pre() {
			  if (${page-1}==0) {				  
				  alert("已经是首页");
					location.href="show?page=${page}"; 
			}else {				
				location.href="show?page=${page-1}";
			} 
		}
		 function next(c) {
			  if (${page+1}>c) {
				alert("已经是尾页");
				location.href="show?page=${page}";
			}else {
				location.href="show?page=${page+1}";
			} 
		} 
	</script>
</html>