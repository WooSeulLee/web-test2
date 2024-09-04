<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.test.web.vo.CarVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	CarVO car = (CarVO)request.getAttribute("car");
%>
<form method="POST" action="/car/car-delete">
<input type="hidden" id="ciNum" name="ciNum" value="<%=car.getCiNum()%>">
<table border="1">
		<tr>
			<th>번호</th>
			<td><%=car.getCiNum()%></td>
		</tr>
		<tr>
			<th>모델명</th>
			<td><%=car.getCiName()%></td>
		</tr>
		<tr>
			<th>년식</th>
			<td><%=car.getCiYear()%></td>
		</tr>
		<tr>
			<th><button type="button" onclick="location.href='/car/car-update?ciNum=<%=car.getCiNum()%>'">수정</button>
			<button>삭제</button></th>
		</tr>
</table>
</form>
</body>
</html>
