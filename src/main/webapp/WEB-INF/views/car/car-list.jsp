<%@page import="java.util.List"%>
<%@page import="com.test.web.vo.CarVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>모델명</th>
			<th>년식</th>
		</tr>
<%
	List<CarVO> cars = (List<CarVO>) request.getAttribute("cars");
	for(CarVO car: cars){
%>
		<tr>
			<td><%=car.getCiNum() %></td>
			<td><a href ="/car/car-view?ciNum=<%= car.getCiNum()%>"><%=car.getCiName() %></a></td>
			<td><%=car.getCiYear() %></td>
		</tr>
<%
	}
%>
	</table>
	<a href="/views/car/car-insert">차량등록</a>
</body>
</html>


