<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.{text-decoration : none;}
</style>
</head>
<body>
	<table align="center" border="1">
	<tr>
		<th>코드</th>
		<th>타이틀</th>
		<th>카테고리</th>
		<th>프로그램</th>
	</tr>
		<c:forEach var="lst" items="${list}">
			<tr>
				<th>${lst.code}<th>
				<th>${lst.title}</th>
				<th><a href="info/${lst.code}">${lst.category}</a></th>
				<th>
				<form action="../sub/delete/${lst.code}" method="post">
				<input type="submit" value="삭제"/>
				</form>
				</th>
				<th>
				<form action="../sub/update/${lst.code}" method="get">
				<input type="submit" value="수정"/>
				</form>
				</th>
				
				
				<!--<th>${lst.description}</th>-->
			</tr>
		</c:forEach>
	</table>
	<table align="center" border="1">
	<tr>
	<th>
	<c:if test="${prev == true}">
	<a href="list?pagenum=${startpage-1}">이전</a>
	</c:if>
	<c:if test="${prev == false}">
	이전
	</c:if>
	</th>
		<c:forEach var="idx" begin="${startpage}" end="${endpage}">
		<th>
		<c:if test="${pagenum == idx}">
			${idx}
		</c:if>
		<c:if test="${pagenum != idx}">
			<a href="list?pagenum=${idx}">${idx}</a>
		</c:if>
		</th>
		</c:forEach>
	<th>
	<c:if test="${next == true}">
	<a href="list?pagenum=${endpage+1}">다음</a>
	</c:if>
	</th>
	</tr>
	</table>
</body>
</html>