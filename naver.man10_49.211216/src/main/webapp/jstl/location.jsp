<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  JSTL의 Format 기능을 사용하기 위한 설정 -->
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<!-- 대표하는 이름을 등록 -->
	<fmt:setBundle basename="intro"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:message key="title"/>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<br/>대문자로 출력:${fn:toUpperCase("Hello world") }
	<br/>소문자로 출력:${fn:substring("Hello world",0,5) }
</body>
</html>