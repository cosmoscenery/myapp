<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형 웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>main</title>

<!-- css -->
<link rel="stylesheet" href="${path}/resources/css/common/header.css">
<link rel="stylesheet" href="${path}/resources/css/common/footer.css">
<link rel="stylesheet" href="${path}/resources/css/common/main.css">


<!-- js -->
 <script src="https://kit.fontawesome.com/5a95e5b6fd.js" crossorigin="anonymous"></script>

<!-- (3-4). 자바스크립트 소스 연결 -->
<!-- defer : html을 다 읽은 후에 자바스크립트를 실행한다. 페이지가 모두 로드된 후에 해당 외부 스크립트가 실행된다 -->
<script src="${path}/resources/js/common/main.js" defer></script>
</head>
<body>
	<div class="wrap">
		<!-- hearder 시작 -->
		<%@ include file="header.jsp" %>
		<!-- hearder 끝 -->
		
		
		<!-- 컨텐츠 시작 -->
		<center>
			<h3> main 영역 </h3>
			<img src="https://img2.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/202304/21/bemypet/20230421120037737gfub.jpg" width="500px" >
		</center>
		<!-- 컨텐츠 끝 -->
	
		<!-- footer 시작 -->
		<%@ include file="footer.jsp" %>
		<!-- footer 끝 -->	
	</div>


</body>
</html>