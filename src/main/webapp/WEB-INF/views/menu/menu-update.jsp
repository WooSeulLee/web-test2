<%@page import="com.test.web.vo.MenuVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
MenuVO menu = (MenuVO)request.getAttribute("menu");
%>

	<form method="POST" action="/menu/menu-update">
		<input type="hidden" id="miNum" name="miNum" value="<%=menu.getMiNum()%>">
		<table border ="1">
			<tr>
				<th>번호</th>
				<td><%=menu.getMiNum() %></td>
			</tr>
			
			<tr>
				<th>메뉴명</th>
				<td><input type="text" id="miName" name="miName" value="<%=menu.getMiName()%>"></td>
			</tr>
			
			<tr>
				<th>가격</th>
				<td><input type="text" id="miPrice" name="miPrice" value="<%=menu.getMiPrice()%>"></td>
			</tr>
			
			<tr>
				<th>메뉴 설명</th>
				<td><input type="text" id="miDesc" name="miDesc" value="<%=menu.getMiDesc()%>"></td>
			</tr>
		</table>
		<button>메뉴 수정</button>
	
	</form>
</body>
</html>