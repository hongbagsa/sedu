<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.CountDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>서블릿 전달한 객체(session)-스크립팅</h2>
<%
	CountDTO dto = (CountDTO)session.getAttribute("objsession");
	if(dto != null){
%>
	추출된 값 : <%= dto.getNumber() %><br>
<%
	}
	else{
%>
	추출된 객체가 없어유
<% } %>
<hr>
<h2>서블릿 전달한 객체(session)-이엘</h2>
	추출된 값 : ${objsession.number}<br>
</body>
</html>