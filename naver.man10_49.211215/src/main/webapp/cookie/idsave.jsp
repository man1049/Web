<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 이용한 데이터 저장</title>
</head>
<body>
<form action="login.jsp" id="loginform">
		아이디
		<%
			//쿠키의 존재 여부를 확인하기 위한 변수
			boolean flag = false;
			//모든 쿠키를 가져오기
			Cookie[] cookies = request.getCookies();
			if(cookies != null && cookies.length > 0){
				for(Cookie cookie : cookies){
					//id 라는 쿠키가 존재한다면
					if(cookie.getName().equals("id")){
						out.println("<input type='text' id='id' name='id' value='"+cookie.getValue()+"'/><br/>");
						
						out.println("<input type='checkbox' id='idsave' name='idsave' checked='checked'/>아이디저장<br/>");
						flag = true;
						break;
					}
				}
			}
			
			if(flag == false){
				out.println("<input type='text' id='id' name='id'/><br/>");
				out.println("<input type='checkbox' id='idsave' name='idsave'/>아이디저장<br/>");
			}
			
			
		
		
		%>
		
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>