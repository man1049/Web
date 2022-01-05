<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- list를 순회하기 위해서 태그 라이브러리 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title></title>
	<!-- css 링크 설정 -->
	<!-- 이 파일은 webapp 디렉토리의 css 디렉토리에 style.css 입니다 
	이런 이유로 외부 자원의 링크는 절대 경로로 설정하는 경우가 많습니다.-->
	<link rel="stylesheet" href="./css/style.css">
	</head>
	<body>
	<a href="fileview" class="menu">파일 목록 보기</a><br/>
	<a href="animal_info.xls" class="menu">엑셀 다운로드</a><br/>
	<a href="excelread" class="menu">엑셀 읽기</a><br/>
	<a href="item.pdf" class="menu">pdf 출력</a><br/>
	<a href="item.json" class="menu">JSON 출력</a><br/>
	
	<a href="item.csv" class="menu">텍스트 출력</a><br/>
	<a href="itemrest.json" class="menu">RESTController</a><br/>
	
	<a href="#" class="menu" id="ajax">ajax json 요청</a><br/>
	<a href="#" class="menu" id="ajaxxml">ajax XML 요청</a><br/>
	
	<a href="exception" class="menu">예외발생</a><br/>
	
	<a href="message" class="menu">스프링 메세지 출력</a><br/>
	
	<a href="fileupload" class="menu">파일 업로드</a><br/>
	
	<div id="disp"></div>
	<div align="center" class="body" >
		<h2>상품 목록</h2>	
		<table border="1">
			<tr class="header">
				<th align="center" width="80">동물 넘버</th>
				<th align="center" width="100">동물 이름</th>
				<th align="center" width="100">동물 가격</th>
			</tr>
			<!-- items에 데이터가 없는 경우 -->
			<c:if test="${fn:length(items) == 0}">
				<tr>
					<td colspan="3" align="center">
						데이터가 없습니다.
					</td>
				</tr>
			</c:if>
			<c:if test="${fn:length(items) != 0}">
			<c:forEach var="items" items="${items}">
				<tr class="record">
					<th align="center" width="80">${items.item_num}</th>
					<th align="center" width="100"><a href="detail/${items.item_num}">${items.item_name}</a></th>
					<th align="center" width="100">${items.item_price}</th>
				</tr>
			</c:forEach>
			</c:if>
		</table>
	</div>
	</body>
	<script>
		//위치에 관계없이 스크립트를 사용하기 위해서 window에 load 이벤트가 발생한 후 작업
		window.addEventListener("load", function(){
			//DOM 객체 찾아오기
			var ajax = document.getElementById("ajax");
			var disp = document.getElementById("disp");
			//alert(ajax);
			//alert(disp);
			
			//클릭 이벤트 처리
			ajax.addEventListener("click", function(e){
				//ajax 요청 객체 생성
				var request = new XMLHttpRequest();
				//요청 생성
				request.open('get', 'itemrest.json')
				//요청 전송
				request.send('');
				//응답이 오면 수행
				request.addEventListener('load', function() {
					//alert(request.responseText);
					
					//json 데이터 파싱 - List 이므로 배열로 생성
					var list = JSON.parse(request.responseText);
					
					//배열을 순회하면서 출력 내용 만들기
					var output = '';
					for(i in list){
						var item = list[i];
						
						output += "<h3>" + item.item_num + "</h3>";
						output += "<p>" + item.item_description + "</p>";
					}
					//disp에 출력
					disp.innerHTML = output;
				});
			});
			
			var ajaxxml = document.getElementById("ajaxxml");
			ajaxxml.addEventListener("click", function(e){
				//ajax 요청 객체 생성
				var request = new XMLHttpRequest();
				//요청 생성
				request.open('get', 'animal.xml')
				//요청 전송
				request.send('');
				//응답이 오면 수행
				request.addEventListener('load', function() {
					//가져온 문자열을 XML로 변환
					var list = request.responseXML;
					//alert(list);
					
					//원하는 태그를 가져옴
					var itemnames = list.getElementsByTagName("item_name");
					var descriptions = list.getElementsByTagName("item_description");
					var output = '';
					for(var i=0; i<itemnames.length; i=i+1){
						var itemname = itemnames[i].childNodes[0].nodeValue;
						var description = descriptions[i].childNodes[0].nodeValue;
						
						output += '<h3>'+itemname+'</h3>';
						output += '<p>'+description+'</p>';
						
					}
					disp.innerHTML = output;
				});
			});
		});
	</script>
</html>