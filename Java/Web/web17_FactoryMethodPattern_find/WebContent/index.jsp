<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">
	#wrap{  
			text-align: center;
			border: 2px dotted green;
	}
	
</style>
</head>
<body>
<div id="wrap">   
	<h2>Cafe Member...Using...EL+JSTL</h2><p>
	
	<a href="search_member.html">회원 검색 하기</a><p></p>
	<c:choose>
		<c:when test="${!empty vo}">
			<a href="front.do?command=showAll">전체 회원 명단 보기</a><p></p>			
			<a href="update.jsp">회원정보 수정하기</a><p></p>	
			<a href="front.do?command=logout">로그아웃 하기</a><p></p>
		</c:when>	
		<c:otherwise>
			<a href="register.html">회원 가입 하기</a><p></p>
			<a href="login.html">로그인 하기</a><p></p>		
		</c:otherwise>
	</c:choose>	
		
</div>
</body>
</html>