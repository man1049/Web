<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- list를 순회하기 위해서 태그 라이브러리 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title></title>
	<!-- css 링크 설정 -->
	<!-- 이 파일은 webapp 디렉토리의 css 디렉토리에 style.css 입니다 
	이런 이유로 외부 자원의 링크는 절대 경로로 설정하는 경우가 많습니다.-->
	<link rel="stylesheet" href="./css/style.css">
	</head>
	<body>
	<div align="center" class="body">
		<h2>상품 목록</h2>	
		<table border="1">
			<tr class="header">
				<th align="center" width="80">동물 넘버</th>
				<th align="center" width="100">동물 이름</th>
				<th align="center" width="100">동물 가격</th>
			</tr>
			<!-- items에 데이터가 없는 경우 -->
			<c:if test="${fn:length(items) == 0}">
				<tr>
					<td colspan="3" align="center">
						데이터가 없습니다.
					</td>
				</tr>
			</c:if>
			<c:if test="${fn:length(items) != 0}">
			<c:forEach var="items" items="${items}">
				<tr class="record">
					<th align="center" width="80">${items.item_num}</th>
					<th align="center" width="100"><a href="detail/${items.item_num}">${items.item_name}</a></th>
					<th align="center" width="100">${items.item_price}</th>
				</tr>
			</c:forEach>
			</c:if>
		</table>
	</div>
	</body>
</html>