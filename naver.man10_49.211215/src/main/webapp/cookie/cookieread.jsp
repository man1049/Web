<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 읽기</title>
</head>
<body>
<%
	//모든 쿠키 가져오기
	Cookie [] cookies = request.getCookies();
	//쿠키가 있는 경우
	if(cookies != null && cookies.length > 0){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("name")){
				out.println("이름 : "+ cookie.getValue());
			}
		}
	}



%>
</body>
</html>