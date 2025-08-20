<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index 페이지</title>
</head>
<body>
 
 <script type="text/javascript">
	setTimeout(function () {
		window.location="${path}/main.do";  // 1초 후에 컨트롤러로 보냄 main.do로 가라 
	}, 1000);
 
</script> 
</body>
</html>