<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a{text-decoration : none;}
</style>
</head>
<body>
	<table align="center" border="1" id="table">
	<tr>
		<th>코드</th>
		<th>이름</th>
		<th>설명</th>
	</tr>
	</table>
	<div align="center" id="pagenum"></div>
</body>
<script>
	//페이지 번호를 저장 할 변수
	var pagenum = 1;
	//데이터를 가져와서 출력하는 함수를 생성
	var adddata = function() {
		//ajax 객체를 생성
		var request = new XMLHttpRequest();
		//요청을 생성
		request.open("GET", "sclist?pagenum="+pagenum);
		//요청을 전송
		request.send('');
		//콜백함수 등록
		request.onreadystatechange = function(){
			if(request.readyState == 4){
				//요청을 전송하고 응답이 오면
				if(request.status >= 200 && request.status < 300){
					//응답 가져오기 - XML이 아닌 경우
					var text = request.responseText;
					//alert(text);
					
					//JSON Parsing
					//여기서 실패하면 서버에서 JSON 데이터 형식을 잘못만든 경우
					var data = JSON.parse(text);
					//alert(data);
					
					//Object 이므로 속성 확인
					/*
					for(var attr in data){
						alert(attr);
					}
					*/
					//기존의 더보기가 있으면 삭제
					var element = document.getElementById('add');
					if(element != null){
						element.parentNode.removeChild(element);
					}
					
					for(var idx=0; idx < data.ar.length; idx = idx + 1){
						
						//idx 번째 데이터를 가져오기
						var sub = data.ar[idx];
						//alert(sub);
						
						//출력문 생성
						var disp = "<tr><td align='right'>" + sub.code + "</td>";
						disp += "<td align='left'>&nbsp;" + "<a href='info/" + sub.code + "'>" + sub.title + "</a></td>";
						disp += "<td align='left'>&nbsp;" + sub.description;
						disp += "</td></tr>";
						
						//table 안에 출력
						document.getElementById("table").innerHTML += disp;
					}
					
					//더보기 생성 - 현재 페이지 번호와 페이지 개수가 다르다면
					
					if(pagenum != data.endpage+1){
						var disp = "<tr id='add'><td colspan = '3' align = 'center'>"
						disp += "더보기" + "</td></tr>";
						document.getElementById("table").innerHTML += disp;
						pagenum = pagenum + 1;
						document.getElementById('add').addEventListener("click",function(e){
							adddata();});
					}
					/*
					for(var idx=1 ; idx < data.endpage+1; idx++){
						
						var disp = "<a href='list?pagenum="+idx+"'>"+idx +"</a>&nbsp";
						document.getElementById('pagenum').innerHTML += disp;
					}
					*/
					
				}
				//요청에 대한 응답 실패
				else{
					alert("응답 실패 : " + request.status);
				}
			
			}
		}
	}
	
	//이 파일이 메모리에 로드되자 마자 adddata라는 함수를 호출하도록 작성
	window.addEventListener("load", function(e) {
		adddata();
	});
</script>
</html>