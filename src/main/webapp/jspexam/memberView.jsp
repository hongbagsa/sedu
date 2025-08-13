<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.MemberDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원정보</h2>
<hr>
<%
	MemberDTO dto = (MemberDTO)request.getAttribute("objtbc");
	if(dto != null){
%>
	회원 이름 : <%= dto.getName() %><br>
	회원 계정 : <%= dto.getId() %><br>
	회원 암호 : <%= dto.getPassword() %><br>
	회원 전화번호 : <%= dto.getNumber() %><br>
<%
	}
	else{
%>
	추출된 객체가 없어유
<% } %>
<hr>
	회원 이름 : ${objtbc.name}<br>
	회원 계정 : ${objtbc.id}<br>
	회원 암호 : ${objtbc.password}<br>
	회원 전화번호 : ${objtbc.number}<br>
	
</body>
</html>