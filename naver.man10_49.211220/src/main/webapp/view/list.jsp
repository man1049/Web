<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border="1">
	<tr>
		<th>코드</th>
		<th>타이틀</th>
		<th>카테고리</th>
		<th>프로그램</th>	
	</tr>
		<c:forEach var="lst" items="${list}">
			<tr>
				<th>${lst.code}<th>
				<th>${lst.title}</th>
				<th><a href="info?code=${lst.code}">${lst.category}</a></th>
				<!--<th>${lst.description}</th>-->
			</tr>
		</c:forEach>
	
	</table>
</body>
</html>