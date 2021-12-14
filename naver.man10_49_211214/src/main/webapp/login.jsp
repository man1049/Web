<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 읽기</title>
</head>
<body>
	<%
	
	response.setHeader("Progma", "no-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Expires","1L");

	
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	//체크박스는 parameterValues를 이용해서 읽어야 함
	String[] auto = request.getParameterValues("autologin");
	
	for(int i = 0 ; i < auto.length ; i++){
		if(auto[i] == null){
			auto[i] = "false";
		}
	}
	
	if(id.equals(null)){
		id = "id입력없음";
	}
	if(pw.equals(null)){
		pw = "pw입력없음";
	}
	System.out.print(id);
	
	%>
	<p><%= id %></p>
	<p><%= pw %></p>
	<p><%= Arrays.toString(auto) %> </p>
	<%
	application.setAttribute("id", id); 
	application.setAttribute("pw", pw);
	%>
	
	
	
</body>
</html>