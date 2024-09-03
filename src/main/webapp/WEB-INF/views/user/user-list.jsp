<%@page import="com.test.web.vo.UserVO" %>
<%@page import= "java.util.List"%>
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
	List<UserVO> users = (List<UserVO>)request.getAttribute("users");
%>

<table border="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
	</tr>
<%
for(UserVO user : users){
%>
	<tr>
		<td><%=user.getUiNum()%></td>
		<td><%=user.getUiId()%></td>
	</tr>
<%
}
%>
</table>
<button onclick="goPage()"> 유저등록 </button>
<script>
function goPage(){
	location.href='/user/user-insert';
}
</script>
</body>
</html>