<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성</title>
<%
	//쿠키생성
	Cookie cookie = new Cookie("name","김백산");
	//쿠키 전송 - 클라이언트의 웹 브라우저에 저장
	response.addCookie(cookie);

%>
</head>
<body>

</body>
</html>