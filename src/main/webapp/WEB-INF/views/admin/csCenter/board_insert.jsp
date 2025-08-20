<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형 웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시글 등록</title>

<!-- css -->
<link rel="stylesheet" href="${path}/resources/css/common/header.css">
<link rel="stylesheet" href="${path}/resources/css/common/footer.css">
<link rel="stylesheet" href="${path}/resources/css/admin/ad_boardList.css">


<!-- js -->
 <script src="https://kit.fontawesome.com/5a95e5b6fd.js" crossorigin="anonymous"></script>

<!-- (3-4). 자바스크립트 소스 연결 -->
<!-- defer : html을 다 읽은 후에 자바스크립트를 실행한다. 페이지가 모두 로드된 후에 해당 외부 스크립트가 실행된다 -->
<script src="${path}/resources/js/common/main.js" defer></script>

<script type="text/javascript">
	
	$(function() {
		//[게시글 작성 버튼] 클릭시 [게시글 작성처리]로 이동
		$("#btnSave").click(function() {
			
			const password = $("#b_password").val();
			const title = $("#b_title").val();
			const content = $("#b_content").val();
			
			if(password == "") {
				alert("비밀번호를 입력하세요!!");
				$("#b_password").focus();
				return false;
			}
			
			if(title == "") {
				alert("글제목을 입력하세요!!");
				$("#b_title").focus();
				return false;
			}
			
			if(content == "") {
				alert("글내용을 입력하세요!!");
				$("#b_content").focus();
				return false;
			}
			document.insertForm.action = "${path}/board_insertAction.bc";
			document.insertForm.submit();
		});
	});

</script>

</head>
<body>
	<div class="wrap">
		<!-- hearder 시작 -->
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<!-- hearder 끝 -->
		
		
		<!-- 컨텐츠 시작 -->
		<div id="container">
			<div id="contents">
				<!-- 상단 중앙1 시작 -->
				<div>
					<h1 align="center">게시글 작성</h1>
				</div>
				<!-- 상단 중앙1 종료 -->
				
				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<!-- 좌측 메뉴 시작 -->
					<%@ include file="/WEB-INF/views/admin/common/leftMenu.jsp" %>
					<!-- 좌측 메뉴 종료 -->
					
					<!-- 우측 화면  시작 -->
					<div id="right">
						<div class="table_div">
						
							<form name="insertForm" method="post">
								<table>
									<tr>
										<th style="width: 200px"> 작성자 </th>
										<td style="width: 200px; text-align=center"> ${sessionScope.sessionID} </td>
										
										<th style="width: 200px"> 비밀번호 </th>
										<td style="width: 200px; text-align : center"> 
											<input style="width: 200px" type="password" class="input" name="b_password" id="b_password" size="30" placeholder="비밀번호 입력" autofocus>
										</td>
									</tr>
									
									<tr>
										<th style="width: 200px"> 글제목 </th>
										<td colspan="3" style="text-align : center">
											<input style="width: 650px" type="text" class="input" name="b_title" id="b_title" size="50" placeholder="글제목 입력" >
										  </td>
									</tr>
									
									<tr>
										<th style="width: 200px"> 글내용 </th>
										<td colspan="3" style="text-align : center">
											<textarea rows="5" cols="93" name="b_content" id="b_content"></textarea>
										 </td>
									</tr>
									
									<tr>
										<td colspan="4" style= "text-align :center"> 
										<br>
											<input type="button" class="inputButton" value="작성" id="btnSave">
											<input type="button" class="inputButton" value="초기화">										
										</td>
									</tr>
									
								</table>
							</form>
						</div>
					</div>
					<!-- 우측 화면  종료 -->
				</div>
				<!-- 상단 중앙2 종료 -->
			</div>
		</div>
		<!-- 컨텐츠 끝 -->
	
		<!-- footer 시작 -->
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- footer 끝 -->	
	</div>


</body>
</html>