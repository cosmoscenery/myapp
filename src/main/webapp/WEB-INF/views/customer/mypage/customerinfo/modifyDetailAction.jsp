<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/common/setting.jsp" %>
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
<link rel="stylesheet" href="${path}/resources/css/customer/join.css">


<!-- js -->
 <script src="https://kit.fontawesome.com/5a95e5b6fd.js" crossorigin="anonymous"></script>

<!-- (3-4). 자바스크립트 소스 연결 -->
<!-- defer : html을 다 읽은 후에 자바스크립트를 실행한다. 페이지가 모두 로드된 후에 해당 외부 스크립트가 실행된다 -->
<script src="${path}/resources/js/common/main.js" defer></script>

<script src="${path}/resources/js/customer/modify.js" defer></script>
</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<%@ include file="../../../common/header.jsp" %>	<!-- customer/webapp/common/header.jsp -->
		<!-- hearder 끝 -->
		
		
		<!-- 컨텐츠 시작 -->
		<div id="container">	<!-- css 나누기 위해 id랑 class 준거임. 이름달라도, 없어도 됨 -->
			<div id="contents">
				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<h1 align="center"> 상세페이지 </h1>
				</div>
				
				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<div id="s2_inner">
						<div class="join">
							<form name="modifyform" action="modifyCustomerAction.do" method="post"
								onsubmit="return modifyCheck()">
								
									<c:if test = "${ selectCnt == 1}">
										<table>
											<tr>
												<th> * 아이디 </th>
												<td>
													${dto.getUser_id()}
												</td>
										 	</tr>
										
											<tr>
												<th> * 비밀번호 </th>
												<td>
													<input type="password" class="input" name="user_password" size="20" placeholder="공백없이 20자 이내로 작성" required >
												</td>
										 	</tr>
										
											<tr>
												<th> * 비밀번호(확인) </th>
												<td>
													<input type="password" class="input" name="re_password" size="20" placeholder="비밀번호 확인" required >
												</td>
										 	</tr>
										 	
										 	<tr>
												<th> * 이름 </th>
												<td>
													<input type="text" class="input" name="user_name" size="50" value = " ${dto.getUser_name()}" placeholder="이름 작성" required >
												</td>
										 	</tr>
										 	
										 	<tr>
												<th> * 생년월일 </th>
												<td>
													<input type="date" class="input" name="user_birthday" size="8" value = "${dto.getUser_birthday()}" placeholder="-없이 생년월일 8자리" required >
												</td>
										 	</tr>
										 	
										 	<tr>
												<th> * 주소 </th>
												<td>
													<input type="text" class="input" name="user_address" size="50"  value = "${dto.getUser_address()}" placeholder="주소 작성" required >
												</td>
										 	</tr>
										 	
										 	<tr>
												<th> 연락처 </th>
														
												<c:if test = "${dto.getUser_hp() == null}"> <!-- 필수가 아니기 떄문에 값 존재 확인 -->
													<td>
														<input type="text" class="input" name="user_hp1" size="3" style="width:50px">
														-
														<input type="text" class="input" name="user_hp2" size="4" style="width:70px">
														-
														<input type="text" class="input" name="user_hp3" size="4" style="width:70px">
													</td>
												</c:if>
												
												<c:if test = "${dto.getUser_hp() != null}">
													<c:set var="hpArr" value="${fn:split(dto.getUser_hp(),'-')}" />
													<td>
														<input type="text" class="input" name="user_hp1" size="3" style="width:50px" value ="${hpArr[0]}">
														-
														<input type="text" class="input" name="user_hp2" size="4" style="width:70px" value ="${hpArr[1]}">
														-
														<input type="text" class="input" name="user_hp3" size="4" style="width:70px" value ="${hpArr[2]}">
													</td>
												</c:if>
										 	</tr>
										 	
										 	<tr>
												<th> * 이메일 </th>
													
													<c:set var="emailArr" value="${fn:split(dto.getUser_email(), '@')}"/>
													<td>
														<input type="text" class="input" name="user_email1" size="20" style="width:100px" value ="${emailArr[0]}" required>
														@
														<input type="text" class="input" name="user_email2" size="4" style="width:100px" value ="${emailArr[1]}" required>
														<select class="input" name="user_email3" style="width:100px" onchange="detail_selectEmailChk()">
															<option value=""> 직접입력 </option>
															<option value="naver.com"> 네이버 </option>
															<option value="googe.com"> 구글 </option>
															<option value="daum.net"> 다음 </option>
															<option value="nate.com"> 네이트 </option>
														</select>
													</td>	
										 	</tr>
										 	
										 	<tr>
										 		<td colspan="2" style="border-bottom:none">
										 		<br>
										 		<div align="right">
										 			<input class="inputBotton" type="submit" value="회원수정">
										 			<input class="inputBotton" type="reset" value="초기화">
										 			<input class="inputBotton" type="button" value="수정취소" onclick="window.location='${path}/main.do'">
										 		</div>
										 	</tr>
									 	
										</table>
									</c:if>
								
									<c:if test = "${ selectCnt != 1}">
										<script type="text/javascript">
											alert("인증실패!!");
											window.location="${path}/modifyCustomer.do"
										</script>
									</c:if>
								
				
							</form>
						</div>  <!-- join 끝 -->
					</div>
				</div>
				<!-- 상단 중앙2 끝 -->
			</div>
		</div>
		<!-- 컨텐츠 끝 -->
	
		<!-- footer 시작 -->
		<%@ include file="../../../common/footer.jsp" %>
		<!-- footer 끝 -->	
	</div>


</body>
</html>