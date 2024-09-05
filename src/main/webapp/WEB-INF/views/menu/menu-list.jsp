<%@page import="com.test.web.vo.MenuVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 리스트</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>메뉴명</th>
			<th>가격</th>
		</tr>
		
<%
	List<MenuVO> menus = (List<MenuVO>) request.getAttribute("menus");
	for(MenuVO menu : menus){
%>
		<tr>
			<td><%=menu.getMiNum()%></td>
			<td><a href="/menu/menu-view?miNum=<%=menu.getMiNum()%>"><%=menu.getMiName()%></a></td> 
			<td><%=menu.getMiPrice() %></td>
		</tr>
<%
	}
%>
	</table>
	<a href="/views/menu/menu-insert">메뉴등록</a>
	
</body>
</html>