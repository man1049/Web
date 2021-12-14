<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답 - 결과 출력</title>
</head>
<body>
<%

//int req_res = (int)request.getAttribute("req_res");
int ses_res = (int)session.getAttribute("ses_res");
int app_res = (int)application.getAttribute("app_res");

//out.print("<p>request : " + req_res + "</p>");
out.print("<p>session : " + ses_res + "</p>");
out.print("<p>application : " + app_res + "</p>");

%>
</body>
</html>