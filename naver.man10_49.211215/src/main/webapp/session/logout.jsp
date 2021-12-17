<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<%
		session.removeAttribute("id");
		session.removeAttribute("name");
		session.removeAttribute("rank");
		session.removeAttribute("login");
		session.setAttribute("login", "logout");
		response.sendRedirect("login.jsp");
	%>
</body>
</html>