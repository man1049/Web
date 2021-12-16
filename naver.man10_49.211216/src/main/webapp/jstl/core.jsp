<%@page import="java.util.Date"%>
<%@page import="java.beans.JavaBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- tsjtl의 core 기능을 사용하기 위한 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="5">
		<p>반갑읍니다</p>
	</c:forEach>
	<!-- 현재 날짜 및 시간을 갖는 데이터 생성 -->
	<c:set var="date" value="<%=new Date()%>"></c:set>

	<!-- 로케일 설정 -->
	<fmt:setLocale value="ko_kr" />

	오늘 날짜
	<fmt:formatDate value="${date}" pattern="yyyy-MM-dd(E) (a) hh:mm:ss" />
	
	<br /> 현재 금액
	<fmt:formatNumber value="${8800000}" type="currency" />
	<br/>
	<fmt:timeZone value="Asia/Seoul">
		오늘 날짜 <fmt:formatDate value="${date}"
			pattern="yyyy-MM-dd(E) (a) hh:mm:ss" />
		<br />
	</fmt:timeZone>
	
	<fmt:timeZone value="Africa/Amazon">
		오늘 날짜 <fmt:formatDate value="${date}"
			pattern="yyyy-MM-dd(E) (a) hh:mm:ss" />
		<br />
	</fmt:timeZone>



</body>
</html>