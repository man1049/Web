<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클라이언트 정보 읽기</title>
</head>
<body>
	<%
	//접속한 컴퓨터의 IP
	String ip = request.getRemoteAddr();

	//컨텍스트 경로
	String contextPath = request.getContextPath();

	//전체 요청 경로
	String requestURI = request.getRequestURI();
	String uri1 = requestURI.split("/")[requestURI.split("/").length-1];
	String uri2 = requestURI.substring(contextPath.length()+1);
	%>
	
	<p>ip : <%= ip %></p>
	<p>컨텍스트 경로 : <%= contextPath %></p>
	<p>전체요청 경로 : <%= requestURI %></p>
	<p>전체요청 경로에서 컨텍스트 경로를 제외한 부분 : <%= uri1 %></p>
	<p>전체요청 경로에서 컨텍스트 경로를 제외한 부분 : <%= uri2 %></p>
</body>
</html>