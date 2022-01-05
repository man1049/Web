<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="fileuploadrequest" method="post" enctype="multipart/form-data">
		이메일:<input type="text" name="email"><br/>
		파일:<input type="file" name="report"><br/>
		<input type="submit" value="전송">
	</form>
	
	<form action="fileuploadparam" method="post" enctype="multipart/form-data">
		이메일:<input type="text" name="email"><br/>
		파일:<input type="file" name="report"><br/>
		<input type="submit" value="전송">
	</form>
	
	<form action="fileuploadcommand" method="post" enctype="multipart/form-data">
		이메일:<input type="text" name="email"><br/>
		파일:<input type="file" name="report"><br/>
		<input type="submit" value="전송">
	</form>

</body>
</html>