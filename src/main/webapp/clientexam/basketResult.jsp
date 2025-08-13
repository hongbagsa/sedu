<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜 목록</title>
</head>
<body>
<h2>선택한 상품의 리스트</h2>
<hr>

<% 
	int[] cnt = (int[]) session.getAttribute("cnt");
%>
<% if (cnt != null) { %>
    <ul>
    <% for(int i = 0; i < cnt.length; i++) { %>
        <% if(cnt[i] != 0) { %>
            <% if(i == 9) { %>
                <li>p010 상품 <%= cnt[i] %>개</li>
            <% } else { %>
                <li>p00<%= i+1 %> 상품 <%= cnt[i] %>개</li>
            <% } %>
        <% } %>
    <% } %>
    </ul>
<% } %>

<% 
    boolean check = false;
    if (cnt != null) {
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                check= true;
                break;
            }
        }
    }
    if (!check) { 
        out.print("<h2>선택한 상품이 없어요.</h2>");
    }
%>
<a href="/sedu/basket2?pid=clear">상품비우기</a><br>
<a href="clientexam/productlog.html">상품선택하기</a>
</body>
</html>