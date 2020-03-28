<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>登录页面</h4>
	
	<form action="${pageContext.request.contextPath}/user/login.do" method="post">
		username:<input name="username"><br>
		password:<input type="password" name="password"><span style="color:red">${errorMsg}</span><br>
		<button type="submit">登录</button>
	</form>
</body>
</html>