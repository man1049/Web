<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세정보</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
<div align="center" class="body">
		<h2>상품 목록</h2>	
		<table border="1">
			<tr class="header">
				<th align="center" width="80">동물 넘버</th>
				<th align="center" width="100">동물 이름</th>
				<th align="center" width="100">동물 가격</th>
				<th align="center" width="100">동물 설명</th>
				<th align="center" width="100">동물 사진</th>
			</tr>
			<!-- items에 데이터가 없는 경우 -->
			<c:if test="${item == null}">
				<tr>
					<td colspan="3" align="center">
						데이터가 없습니다.
					</td>
				</tr>
			</c:if>
			<c:if test="${item != null}">
				<tr class="record">
					<th align="center" width="80">${item.item_num}</th>
					<th align="center" width="100">${item.item_name}</th>
					<th align="center" width="100">${item.item_price}</th>
					<th align="center" width="100">${item.item_description}</th>
					<th align="center"><img alt="${item.item_name}" src="../picture/${item.item_picture}">
				</tr>
				<tr></tr><a href="/prac">목록으로</a>
			</c:if>
		</table>
	</div>
</body>
</html>