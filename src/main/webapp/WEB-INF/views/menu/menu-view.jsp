<%@page import="com.test.web.vo.MenuVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 상세 페이지</title>
</head>
<body>
<%
	MenuVO menu = (MenuVO)request.getAttribute("menu");
%>
<form method="POST" action="/menu/menu-delete">
<input type="hidden" id="miNum" name="miNum" value="<%=menu.getMiNum()%>">
<table border="1">
		<tr>
			<th>메뉴번호</th>
			<td><%=menu.getMiNum()%></td>
		</tr>
		<tr>
			<th>메뉴명</th>
			<td><%=menu.getMiName()%></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><%=menu.getMiPrice()%></td>
		</tr>
		<tr>
			<th>메뉴소개</th>
			<td><%=menu.getMiDesc()%></td>
		</tr>
		<tr>
			<th colspan="2"><button type="button" onclick="location.href='/menu/menu-update?miNum=<%=menu.getMiNum()%>'">메뉴 수정</button>
			<button>삭제</button></th>
		</tr>
</table>
</form>
</body>
</html>