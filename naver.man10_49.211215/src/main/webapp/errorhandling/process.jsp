<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 에러가 발생했을 시 보여질 페이지 -->
    <%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처리</title>
</head>
<body>
	<%
	
	String su1 = request.getParameter("su1");
	String su2 = request.getParameter("su2");
	
	int res = Integer.parseInt(su1)/Integer.parseInt(su2);
	
	request.setAttribute("res", res);
	
	RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
	
	rd.forward(request, response);

	%>
</body>
</html>