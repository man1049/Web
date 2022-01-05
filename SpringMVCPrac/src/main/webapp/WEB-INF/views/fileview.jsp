<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>파일목록</h2>	
		<table border="1">
			<tr>
				<th width="250">파일명</th>
			</tr>
			<c:forEach var="file" items="${list}">
			<tr>
				<!-- <th><a href="./picture/${file}">${file}</a> -->
				<td><a href="/download?file=${file}">${file}</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>