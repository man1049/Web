<%@page import="util.CryptoUtil"%>
<%@page import="javax.swing.plaf.basic.BasicTextUI.BasicCaret"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="connect">DB연결</a>
	<a href="sub/list">select 가져오기</a>
	<a href="sub/insertpage">추가하기</a>
</body>
	<%@ page import = "org.mindrot.jbcrypt.BCrypt" %>
	<%
		//복호화가 불가능하도록 암호화
		String pw = "kimbacksan";
		//비문 생성 - 동일한 데이터를 갖고 해도 다른 결과
		String scpw = BCrypt.hashpw(pw, BCrypt.gensalt(10));
		out.println("<br/> 변경 된 비밀번호 : "+scpw);
		scpw = BCrypt.hashpw(pw, BCrypt.gensalt(10));
		out.println("<br/> 변경 된 비밀번호 : "+scpw);
		
		//비교는 가능
		out.println("</br>비교 : " + BCrypt.checkpw(pw, scpw));
		out.println("</br>비교 : " + BCrypt.checkpw("kimbacksa", scpw));
		
		//복호화가 가능하도록 암호화
		CryptoUtil cryptoUtil = new CryptoUtil();
		String email = "man10_49@naver.com";
		
		//동일한 데이터로 2번 수행하면 결과는 같습니다.
		String scemail =  cryptoUtil.encrypt(email);
		out.println("<br/> 암호화 : "+scemail);
		scemail =  cryptoUtil.encrypt(email);
		out.println("<br/> 암호화 : "+scemail);
		
		String desc = cryptoUtil.decrypt(scemail);
		out.println("<br/> 암호화 : "+desc);
		
		//랜덤한 문자열 생성하기
		String randomString = java.util.UUID.randomUUID().toString();
		out.println("</br>랜덤 문자열 : " + randomString);
	%>
</html>