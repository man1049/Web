<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답 페이지</title>
</head>
<body>
	<%
	//처리 한 곳에서 넘겨준 데이터 가져오기
	int res = (int)request.getAttribute("res");

	out.println("<p>num1+num2 = "+res+"</p>");

	%>

	<!-- 스크립트릿을 이용 한 출력 -->
	<p><%= res %></p>
	<!-- EL을 이용 한 출력 : attribute 이름을 직접 사용해서 출력 -->
	<p>${res}</p>
	<!-- EL을 이용 한 파라미터 출력 -->
	<p>${param.num1}</p>
	<!-- El을 이용 한 초기화 파라미터 출력 -->
	<p>${initParam.init}</p>
	<!-- 다른 객체의 속성 가져오기 -->
	<p>${pageContext.request.requestURI}</p>
	<p>${pageContext.request.remoteAddr}</p>
	
	<!-- 배열과 리스트 그리고 Map의 출력 -->
	<p>${ar[0]}</p>
	<p>${list[0]}</p>
	<p>${map["name2"] }</p>
	<p>${map.name1}</p>
</body>
</html>