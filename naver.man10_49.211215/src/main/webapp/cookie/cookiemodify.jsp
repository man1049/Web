<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//쿠키는 Map 형식이기 때문에 같은 키로 저장을 하면
	//덮어 씌워짐
	Cookie cookie = new Cookie("name","소백산");
	response.addCookie(cookie);
	
	%>

</body>
</html>