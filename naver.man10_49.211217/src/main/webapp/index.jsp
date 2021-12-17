<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<p>어서오세요</p>
	<a href="insert.main?name=김백산">데이터삽입</a><br/>
	<a href="logout.main">로그아웃</a><br/>
</body>
<script>
	window.addEventListener("beforeunload", function(e) {
		//ajax 요청으로 logout을 수행
		var request = new XMLHttpRequest();
		request.open("GET","logout.main");
		request.send('');
	})

</script>
</html>