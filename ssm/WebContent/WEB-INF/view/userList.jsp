<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入核心类库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="border-collapse: collapse;">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>password</th>
			<th>age</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.password}</td>
				<td>${user.age}</td>
				<td><a href="javascript:void(0);"
					onclick="deleteUserById(${user.id})">删除</a> <a href="#">修改</a></td>
			</tr>
		</c:forEach>
	</table>

	<script type="text/javascript">
		function deleteUserById(id){
			if(confirm("确定删除吗?")){
				window.location.href = "${pageContext.request.contextPath}/user/delete.do?id="+id;
			}
		}
	</script>
</body>
</html>