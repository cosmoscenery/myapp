<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형 웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>상품등록</title>

<!-- css -->
<link rel="stylesheet" href="${path}/resources/css/common/header.css">
<link rel="stylesheet" href="${path}/resources/css/common/footer.css">
<link rel="stylesheet" href="${path}/resources/css/admin/ad_boardList.css">

<!-- js -->
<script src="https://kit.fontawesome.com/b435fbc087.js" crossorigin="anonymous"></script>

<!-- (3-4). 자바스크립트 소스 연결 -->
<!-- defer : html을 다 읽은 후에 자바스크립트를 실행한다. 페이지가 모두 로드된 후에 해당 외부 스크립트가 실행된다. -->
<script src="${path}/resources/js/common/main.js" defer></script>

</head>
<body>
   <div class="wrap">
      <!-- header 시작 -->
      <%@ include file="/WEB-INF/views/common/header.jsp" %>
      <!-- header 끝 -->
      
      <!-- 컨텐츠 시작 -->
      <div id="container">
         <div id="contents">
            <!-- 상단 중앙1 시작 -->
            <div>
               <h1 align="center">상품 등록처리</h1>
            </div>
            <!-- 상단 중앙1 종료 -->
            
            <!-- 상단 중앙2 시작 -->
            <div id="section2">
               <!-- 좌측메뉴 시작 -->
               <%@ include file="/WEB-INF/views/admin/common/leftMenu.jsp" %>
               <!-- 좌측메뉴 종료 -->
               
               <!-- 우측 화면 시작 -->
               <c:if test="${insertCnt == 1}">
               		<script type="text/javascript">
               			setTimeout(function() {
               				alert("상품등록 성공!!")
               				window.location="${path}/ad_product_list.pd";
               			}, 1000);
               		</script>
               </c:if>	
               
               <c:if test="${insertCnt != 1}">
               		<script type="text/javascript">
               			setTimeout(function() {
               				alert("상품등록 실패!!")
               				window.location="${path}/ad_product_add.pd";
               			}, 1000);
               		</script>
               </c:if>	
               
               <!-- 우측 화면 종료 -->
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