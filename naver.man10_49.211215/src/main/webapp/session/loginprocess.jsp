<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션</title>
</head>
<body>
	<%
		//입력받은 파라미터 가져오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//로그인 성공 한 경우
		if(id.equals("김백산") && pw.equals("1324")){
			session.setAttribute("id", id);
			session.setAttribute("name", "김백산");
			session.setAttribute("rank", "관리자");
			session.setAttribute("login", "true");
			response.sendRedirect("login.jsp");
		}else{
			session.removeAttribute("id");
			session.removeAttribute("name");
			session.setAttribute("login", "false");
			

			response.sendRedirect("login.jsp");
		}
		
		
		
	%>

</body>
</html>