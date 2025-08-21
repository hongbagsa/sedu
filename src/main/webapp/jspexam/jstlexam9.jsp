<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %> 
<!DOCTYPE html>
<html> 
<head> 
<meta charset="UTF-8">
<title>JSTL 테스트</title>
<style>
table, td, th {
	border : 1px solid black;
}
td {
	text-align : center;
}
</style>
</head>
<body>
<h2>기상청 날씨정보(XML)를 읽어오는 예제</h2>
<hr>
<c:catch var="err">   
  <c:import var="weather" 
 		url="http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?ServiceKey=%2BjzsSyNtwmcqxUsGnflvs3rW2oceFvhHR8AFkM3ao%2Fw50hwHXgGyPVutXw04uAXvrkoWgkoScvvhlH7jgD4%2FRQ%3D%3D&pageNo=1&numOfRows=1000&dataType=XML&base_date=20250820&base_time=1400&nx=60&ny=127">
  </c:import>
  <!-- xml 파싱하기 -->
  <x:parse varDom="w" xml="${weather}"></x:parse>
  <h3><x:out select="$w/response/body/dataType"></x:out>로 응답된 날씨 정보</h3>   
  <table>
     <tr>
         <th colspan="2" >날짜 : <x:out select="$w/response/body/items/item/baseDate"/> 
         	발표시간 : <x:out select="$w/response/body/items/item/baseTime"/> 
         </th>
     </tr>     
     <tr>
         <td>기온 </td>
         <td>
               <x:out select="$w/response/body/items/item[4]/obsrValue"/> &#8451;
        </td>
     </tr>   
     <tr>
         <td>습도 </td>
         <td> 
              <x:out select="$w/response/body/items/item[2]/obsrValue"/> % 
         </td>
     </tr>    
  </table>
</c:catch>
<c:if test="${!empty err}">
   <h2>오류 발생!!</h2>
   ${err}
</c:if> 
</body>
</html>