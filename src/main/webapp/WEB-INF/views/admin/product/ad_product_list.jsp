<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형 웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>boardList</title>

<!-- css -->
<link rel="stylesheet" href="${path}/resources/css/common/header.css">
<link rel="stylesheet" href="${path}/resources/css/common/footer.css">
<link rel="stylesheet" href="${path}/resources/css/admin/ad_boardList.css">

<!-- js -->
<script src="https://kit.fontawesome.com/b435fbc087.js" crossorigin="anonymous"></script>

<!-- (3-4). 자바스크립트 소스 연결 -->
<!-- defer : html을 다 읽은 후에 자바스크립트를 실행한다. 페이지가 모두 로드된 후에 해당 외부 스크립트가 실행된다. -->
<script src="/jsp_pj_ict05/resources/js/common/main.js" defer></script>

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
               <h1 align="center">상품 목록</h1>
            </div>
            <!-- 상단 중앙1 종료 -->
            
            <!-- 상단 중앙2 시작 -->
            <div id="section2">
               <!-- 좌측메뉴 시작 -->
               <%@ include file="/WEB-INF/views/admin/common/leftMenu.jsp" %>
               <!-- 좌측메뉴 종료 -->
               
               <!-- 우측 화면 시작 -->
               <div id="right">
                  <div class="table_div">
                     
                     <form name="productList">
                        <table>
                           <tr>
                              <th>상품번호</th>
                              <th>상품명</th>
                              <th>브랜드</th>
                              <th>상품이미지</th>
                              <th>카테고리</th>
                              <th>상품가격</th>
                              <th>등록수량</th>
                              <th>상태</th>
                              <th>등록일</th>
                              <th>수정</th>
                              <th>삭제</th>
                           </tr>   
                           
                           <!-- 상품이 있으면 -->   
                           <c:forEach var="dto" items="${list}">   
                              <tr>
                                 <td> ${dto.pdNo} </td>
                                 <td> ${dto.pdName} </td>
                                 <td> ${dto.pdBrand}</td>
                                 
                                 <!-- upload 폴더를 새로고침, 브라우저도 새로고침해야 깨진 이미지가 제대로 보임 -->
                                 <td> <img src="${dto.pdImg}" width="100px"> </td>
                                 <td> ${dto.pdCategory} </td>
                                 <td> ${dto.pdPrice} </td>
                                 <td> ${dto.pdQuantity} </td>
                                 <td> ${dto.pdStatus} </td>
                                 <td> ${dto.pdIndate} </td>
                                 <td>
                                    <center>
                                       <input class="inputButton" type="button" value="수정"
                                          onclick="window.location='${path}/ad_product_detailAction.pd?pdNo=${dto.pdNo}&pageNum=${paging.pageNum}'">
                                    </center>
                                 </td>
                                 
                                 <td>
                                    <center>
                                       <input class="inputButton" type="button" value="삭제"
                                          onclick="window.location='${path}/ad_product_deleteAction.pd?pdNo=${dto.pdNo}'">
                                    </center>
                                 </td>
                              </tr>            
                           </c:forEach>
                                    
                           <tr>
                              <td colspan="11" align="center">
                                 <ul class="pagination">
                                    <!-- 페이징 처리 -->
                                    <!-- 이전 버튼 활성화 -->
                                    <c:if test="${paging.startPage > 10}">
                                       <li>
                                          <a href="${path}/ad_product_list.pd?pageNum=${paging.prev}" class="prevPage"> [이전] </a>
                                       </li>
                                    </c:if>
                                    
                                    <!-- 페이지 번호 처리 -->
                                    <c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
                                       <li>
                                          <a href="${path}/ad_product_list.pd?pageNum=${num}" 
                                             class="<c:if test='${num == paging.currentPage}'> 
                                                         active 
                                                    </c:if>">
                                          ${num} 
                                          </a>
                                       </li>
                                    </c:forEach>
                                    
                                    <!-- 다음 버튼 활성화 -->
                                    <c:if test="${paging.endPage < paging.pageCount}">
                                       <li>
                                          <a href="${path}/ad_product_list.pd?pageNum=${paging.next}" class="nextPage"> [다음] </a>
                                       </li>
                                    </c:if>
                                 </ul>
                              </td>
                           </tr>   
                                             
                        </table>
                     </form>
                  </div>               
               </div>   
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