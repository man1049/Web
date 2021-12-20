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
	
	//로그를 출력
	System.out.println("새로 고침을 하면 수행됩니다.");
	
	//출력 페이지로 이동 - 포워드
	RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
	rd.forward(request, response);
	%>

</body>
</html>