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
	//name 이라는 쿠키가 존재하면 수정이고 존재하지 않으면 추가
	Cookie cookie = new Cookie("name","");
	//쿠키의 maxAge를 0으로 설정하면 쿠키가 삭제됨
	//0이 아닌 양수를 대입하면 그 양수 만큼의 시간이 지나면 삭제
	//음수를 대입하면 브라우저를 종료 할 때 삭제
	cookie.setMaxAge(0);
	response.addCookie(cookie);
	
	
	
	%>

</body>
</html>