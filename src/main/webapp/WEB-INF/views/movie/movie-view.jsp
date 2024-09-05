<%@page import="com.test.web.vo.MovieVO"%>
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
	MovieVO movie = (MovieVO)request.getAttribute("movie"); 
%>
<form method="POST" action="/movie/movie-delete">
<table border="1">
<input type="hidden" id="miNum" name="miNum" value="<%=movie.getMiNum()%>">
	<tr>
		<th>번호</th>
		<td><%=movie.getMiNum()%></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><%=movie.getMiName()%></td>
	</tr>
	<tr>
		<th>감독</th>
		<td><%=movie.getMiDirector()%></td>
	</tr>
	<tr>
		<th>장르</th>
		<td><%=movie.getMiGenre()%></td>
	</tr>
	<tr>
		<th>개봉일</th>
		<td><%=movie.getMiYear()%></td>
	</tr>
	<tr>
		<th colspan="2">
		<button type="button" onclick="location.href='/movie/movie-update?miNum=<%=movie.getMiNum()%>'">정보 수정</button>
		<button>삭제</button>
		</th>
	</tr>
	</table>
</form>
</body>
</html>