<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../sub/insert" method="post" >
		<input type="text" name="title" placeholder="타이틀" required="required">
		<br/>
		축구<input type="radio" name="category" value="축구">
		농구<input type="radio" name="category" value="농구">
		야구<input type="radio" name="category" value="야구">
		배구<input type="radio" name="category" value="배구">
		<br/>
		<textarea rows="10" cols="50" name="description" maxlength="300" placeholder="설명을 입력해주세요."></textarea>
		<input type="submit" value="전송">
	</form>
</body>
</html>