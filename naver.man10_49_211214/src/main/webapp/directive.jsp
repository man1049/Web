<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directive - 지시자</title>
</head>
<body>
	<p>
		<%@page import="java.util.*"%>
		<!-- 공백 제거 -->
		<%@ page trimDirectiveWhitespaces="true"%>
		<%
		Calendar cal = new GregorianCalendar();
		Date date = new Date(cal.getTimeInMillis());
		
		%>
		<!-- 자바로 만들 데이터 출력 -->
		<%= date%>
	</p>
</body>
</html>