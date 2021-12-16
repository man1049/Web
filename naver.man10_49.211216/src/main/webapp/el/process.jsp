<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처리</title>
</head>
<body>
<%
	//파라미터 읽기
	request.setCharacterEncoding("utf-8");
	String num1 = request.getParameter("num1");
	String num2 = request.getParameter("num2");
	
	//처리
	//2개의 데이터를 더 해서 결과를 생성
	int res = Integer.parseInt(num1)+Integer.parseInt(num2);
	
	//전달 할 결과를 저장
	request.setAttribute("res", res);
	
	String[] ar = {"Oracle", "MySQL", "MongoDB"};
	
	List <String> list = new ArrayList<>();
	
	list.add("Java");
	list.add("JavaScript");
	list.add("Python");
	
	Map<String,Object> map = new HashMap<>();
	map.put("name1", "김백산");
	map.put("name2", "소백산");
	map.put("name3", "태백산");
	request.setAttribute("map", map);
	request.setAttribute("list", list);
	request.setAttribute("ar", ar);
	
	//결과 페이지로 이동
	RequestDispatcher rd = request.getRequestDispatcher("respon.jsp");
	rd.forward(request, response);
	


%>

</body>
</html>