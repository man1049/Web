<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<jsp:include page="WEB-INF/sub.jsp"></jsp:include> -->
<!--  <%@ include file="WEB-INF/sub.jsp" %> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 입력</title>
</head>
<body>
	<form action="login.jsp" method="post">
		<p>아이디　　<input type="text" id="login_id" name="id" />
		<p>비밀번호　<input type="text" id="login_pw" name="pw"/>
		<p>자동로그인<input type="checkbox" id="auto_login" name="autologin" value="auto">
		<p>아이디만 기억<input type="checkbox" id="auto_login" name="autologin" value="id">
		<p>비밀번호만 기억<input type="checkbox" id="auto_login" name="autologin" value="pw">
		<p>
		<p><input type="submit" value="로그인">
		</form>
		<% 
		//java에서 초기화 파라미터 읽기
		String id = application.getInitParameter("id");
		out.print("초기화 파라미터 : "+id);
		%>
</body>
</html>