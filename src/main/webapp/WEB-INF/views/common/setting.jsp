<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl -->
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 컨텍스트패스 즉, 플젝명(spring_pj_ict05 => 세번째 패키지)를 path 변수에 설정 -->
<c:set var="path" value="${pageContext.request.contextPath}" /> 	<!-- value="spring_pj_ict05" -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script> <!-- 따로 닫아야 한다. -->