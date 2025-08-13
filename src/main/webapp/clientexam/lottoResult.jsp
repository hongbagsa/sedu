<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="lab.LottoServlet3"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로또 결과</title>
</head>
<body>
<%
	String msg = (String) session.getAttribute("msg");
	String imginfo = (String) session.getAttribute("imginfo");
	session.removeAttribute("msg");
    session.removeAttribute("imginfo");
%>
<% if (msg != null && imginfo != null) { %>
    <h2><%= msg %></h2>
    <hr>
    <img src="<%= imginfo %>">
    <%if(msg.equals("실패~~~ 아쉬아쉽")){ %>
    <br>
    <a href="/sedu/clientexam/lottoForm3.html">요청</a>
<% }
   } else if (msg != null && imginfo == null) { %>
    <h2><%= msg %></h2>
<% } else { %>
    <h2>로또 결과가 없습니다.</h2>
<% } %>
</body>
</html>