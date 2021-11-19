<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>c:foreach 사용법</h2>
<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("사과");
	list.add("바나나");
	list.add("복숭아");
	list.add("포도");
	
	request.setAttribute("list",list);
	
//	request.getRequestDispatcher("cForEach4_result.jsp").forward(request,response);
	
%>

<jsp:forward page="cForEach4_result.jsp"></jsp:forward>


</body>
</html>