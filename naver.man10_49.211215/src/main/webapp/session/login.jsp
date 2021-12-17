<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	
	
	
	<%
		//로그인 안된 상태
		if(session.getAttribute("login") == "false"){
			out.println("<script> alert('로그인 실패') </script>");
			session.removeAttribute("login");
		}
		if(session.getAttribute("login") == "logout"){
			out.println("<script> alert('로그아웃 되었습니다.') </script>");
			session.removeAttribute("login");
		}
		if(session.getAttribute("id") == null){
			out.println("<form action='loginprocess.jsp'>"
					+"<input type='text' required='required' placeholder='아이디' id='id' name='id'> <br/>"
					+"<input type='text' required='required' placeholder='비밀번호' id='pw' name='pw'> <br/>"
					+"자동로그인 <input type='checkbox' id='idsave' name='idsave'>"
					+"<input type='submit'>"
				+"</form>");
			
			
		}else{ //로그인 된 상태
			String name = (String)session.getAttribute("name");
			String rank = (String)session.getAttribute("rank");
			session.removeAttribute("login");
			out.println(name+" "+rank);
			out.println("<br/> <a href='logout.jsp'>로그아웃</a>");
		}
	
	
	%>
</body>
</html>