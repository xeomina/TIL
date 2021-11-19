<!-- 
JSTL사용하기위한 방법
1. ~jar파일(2개)을 반드시 추가...lib안에

2. taglib를 선언부에 지정..
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${param.num=='100'}">
	<h1>오늘 100만원 입금하셨습니다.</h1>
</c:if>
<c:if test="${param.num=='200'}">
	<h1>오늘 100만원 입금하셨습니다.</h1>
</c:if>
</body>
</html>















