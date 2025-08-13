<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.CountDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>서블릿 전달한 객체(application)</h2>
<hr>
<%
	CountDTO dto = (CountDTO)application.getAttribute("objapp");
	if(dto != null){
%>
	추출된 값 : <%= dto.getNumber() %><br>
<%
	}
	else{
%>
	추출된 객체가 없어유
<% } %>
<h2>서블릿 전달한 객체(application)</h2>
<hr>
	추출된 값 : ${objapp.number}<br>
</body>
</html>