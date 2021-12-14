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
	//파라미터 읽어와서 정수로 변환 후 더해주기
	int res = Integer.parseInt(request.getParameter("int1")) 
	+ Integer.parseInt(request.getParameter("int2"));
	
	//결과를 저장
	request.setAttribute("req_res", res);
	session.setAttribute("ses_res", res);
	application.setAttribute("app_res", res);

	//로그 출력
	System.out.println("새로고침 해도 출력 안됨");
	
	//출력 페이지로 이동 - 리다이렉트
	response.sendRedirect("output.jsp");
	%>

</body>
</html>