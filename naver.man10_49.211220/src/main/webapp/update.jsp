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
	<form action="../sub/update" method="post" >
		<input type="text" name="code" hidden="true" readonly="readonly" value="${info.code }" />
		<input type="text" name="title" placeholder="타이틀" required="required" value="${info.title}">
		<br/>
		
		축구<input type="radio" name="category" value="축구" <c:if test="${info.category == '축구'}">checked="checked"</c:if>/>
		농구<input type="radio" name="category" value="농구" <c:if test="${info.category == '농구'}">checked="checked"</c:if>/>
		야구<input type="radio" name="category" value="야구" <c:if test="${info.category == '야구'}">checked="checked"</c:if>/>
		배구<input type="radio" name="category" value="배구" <c:if test="${info.category == '배구'}">checked="checked"</c:if>/>
		<br/>
		<textarea rows="10" cols="50" name="description" maxlength="300" placeholder="설명을 입력해주세요.">${info.description}</textarea>
		<input type="submit" value="전송">
	</form>
</body>
</html>