<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JYP</title>
</head>
<body>
<div>
<%	
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
	String userName = request.getParameter("username");
	String Room = request.getParameter("room");
	String money[] = request.getParameterValues("moremoney");
	String date = request.getParameter("date");
	String[] arr = date.toString().split("-");%>
<h2><%= userName %>의 예약 내용</h2><hr>
<ul>
<%
if(Room != null) {
	out.print("<li>선택한 룸 : "+Room+"</li>");
}
else {
	out.print("<li>예약된 방이 없습니다。</li>");
}
if(money != null && money.length !=0) {
	for(String M:money) {
		out.print("<li> 추가 요청 사항 : "+M+"</li>");
	}
}
else {
	out.print("<li>예약된 서비스가 없습니다。 돈을 더 써주세요。</li>");
}
out.print("<li>예약날짜 : "+arr[0]+"년 "+arr[1]+"월 "+arr[2]+"일 "+"</li>");
%>
</ul>
</div>
</body>
</html>