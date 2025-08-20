<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형 웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>상세페이지</title>

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
	$(function() { // 상세페이지가 로딩되면
		
		// [게시글 목록 버튼] 클릭시 컨트롤러의 목록으로 이동
		$('#btnList').click(function() {
			location.href="${path}/board_list.bc";
		});
	

		// [게시글 수정 버튼] 클릭시 [게시글 수정처리]으로 이동
		$('#btnEdit').click(function(){
			document.editForm.action="${path}/board_updateAction.bc";
			document.editForm.submit();
		});
		
		// [게시글 삭제 버튼] 클릭시 [게시글 삭제 처리]으로 이동
		$('#btnDelete').click(function(){
			document.editForm.action="${path}/board_deleteAction.bc";
			document.editForm.submit();
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
					<h1 align="center">게시판 수정 삭제페이지</h1>
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
						
							<form name="editForm" method="post">
								<table>
									<tr>
										<th style="width: 200px"> 글번호 </th>
										<td style="width: 200px; text-align=center"> ${dto.b_num} </td>
										
										<th style="width: 200px"> 조회수 </th>
										<td style="width: 200px; text-align=center"> ${dto.b_readCnt} </td>
									</tr>
									
									<tr>
										<th style="width: 200px"> 작성자 </th>
										<td style="width: 200px; text-align=center"> ${dto.b_writer} </td>
										
										<th style="width: 200px"> 비밀번호 </th>
										<td style="width: 200px; text-align=center"> 
											<input style="width: 200px" type="password" class="input" name="b_password" id="b_password" size="30" placeholder="비밀번호 입력" required autofocus>
										</td>
									</tr>
									
									<tr>
										<th style="width: 200px"> 글제목 </th>
										<td colspan="3" style="text-align= center">
											<input style="width: 650px" type="text" class="input" name="b_title" id="b_title" size="50" value="${dto.b_title}" placeholder="글제목 입력" required >
										  </td>
									</tr>
									
									<tr>
										<th style="width: 200px"> 글내용 </th>
										<td colspan="3" style="width: 200px; text-align=center">
											<textarea rows="5" cols="93" name="b_content"> ${dto.b_content}</textarea>
										 </td>
									</tr>
									
									<tr>
										<th style="width: 200px"> 작성일 </th>
										<td colspan="3" style= "text-align=center"> ${dto.b_regDate} </td>
									</tr>
									
									<tr>
										<td colspan="4" style= "text-align=center"> 
										<br>
											<!-- 게시글번호 hidden 추가 : input이 없으므로 (게시글 번호는 입력받지 않으므로 input이 없음) -->
											<input type="hidden" name="hidden_b_num" value="${dto.b_num}">
											<input type="button" class="inputButton" value="목록" id="btnList">
											<input type="button" class="inputButton" value="수정" id="btnEdit">
											<input type="button" class="inputButton" value="삭제" id="btnDelete">										
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