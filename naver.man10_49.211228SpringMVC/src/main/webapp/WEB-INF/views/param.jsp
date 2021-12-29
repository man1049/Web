<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="paramres" method="post">
		<input type="text" placeholder="아이디" name="id" id="id"> <br/>
		<input type="text" placeholder="비밀번호" name="pw" id="pw"> <br/>
		<input type="text" placeholder="이메일" name="mail" id="mail"> <br/>
		남자<input type="radio" name="gend" value="남자" checked="checked">  
		여자<input type="radio" name="gend" value="여자">
		<input type="submit">
	</form>
</body>
</html>