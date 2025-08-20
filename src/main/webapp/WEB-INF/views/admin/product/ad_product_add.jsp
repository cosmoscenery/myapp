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
               <h1 align="center">상품 등록페이지</h1>
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
                     
                     <form name="ad_product_add" action="ad_product_addAction.pd" method="post" enctype="multipart/form-data">
                        <table>
                           <tr>
                              <th> * 브랜드 </th>
                              <td>    
                                 <input type="text" class="input" name="pdBrand" id="pdBrand" size="50" placeholder="50자 이내 브랜드 작성" required autofocus>
                              </td>
                           </tr>   
                           
                           <tr>
                              <th> * 상품명 </th>
                              <td>    
                                 <input type="text" class="input" name="pdName" id="pdName" size="50" placeholder="50자 이내 상품명 작성" required>
                              </td>
                           </tr>   
                           
                           <tr>
                              <th> * 상품이미지 </th>
                              <td>    
                                 <input type="file" class="input" name="pdImg" id="pdImg" accept="image/*" required>
                              </td>
                           </tr>   
                           
                           <tr>
                              <th> * 상품카테고리 </th>
                              <td>    
                                 <select class="input" name="pdCategory" id="pdCategory" required>
                                    <option value="">상품카테고리</option>
                                    <option value="주방가전">주방가전</option>
                                    <option value="생활가전">생활가전</option>
                                    <option value="휴대폰">휴대폰</option>
                                 </select>
                              </td>
                           </tr>   
                           
                           <tr>
                              <th> * 상품설명 </th>
                              <td>    
                                 <textarea rows="5" cols="77" name="pdContent" id="pdContent" placeholder="상품설명 작성"></textarea>
                              </td>
                           </tr>   
                           
                           <tr>
                              <th> * 상품가격 </th>
                              <td>    
                                 <input type="number" class="input" name="pdPrice" id="pdPrice" size="10" placeholder="상품가격 작성" required>
                              </td>
                           </tr>   
                           
                           <tr>
                              <th> * 상품수량 </th>
                              <td>    
                                 <input type="number" class="input" name="pdQuantity" id="pdQuantity" size="10" placeholder="상품수량 작성" required>
                              </td>
                           </tr>   
                           
                           <tr>
                              <th> * 상품상태코드 </th>
                              <td>    
                                 <select class="input" name="pdStatus" id="pdStatus" required>
                                    <option value="">상품상태코드</option>
                                    <option value="판매중">판매중</option>
                                    <option value="입고대기">입고대기</option>
                                    <option value="품절">품절</option>
                                 </select>
                              </td>
                           </tr>   
                           
                           <tr>
                              <td colspan="2" style="text-align:center"> 
                              <br>
                                 <input type="submit" class="inputButton" value="상품등록">
                                 <input type="button" class="inputButton" value="초기화">
                                 <input type="button" class="inputButton" value="상품목록" onclick="window.location='${path}/ad_product_list.pd'">
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