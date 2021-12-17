<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 저장</title>
</head>
<body>
	<%
		//이전 페이지에 전송 된 파라미터 읽기
		String id = request.getParameter("id");
		String idsave = request.getParameter("idsave");
		
		//idsave 체크 여부에 따라 분기
		if(idsave == null){
			Cookie[] cookies = request.getCookies();
			if(cookies != null && cookies.length != 0){
				for (Cookie cookie : cookies){
					if(cookie.getName().equals("id")){
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		}else{
			Cookie cookie = new Cookie("id",id);
			response.addCookie(cookie);
		}


	%>

</body>
</html>