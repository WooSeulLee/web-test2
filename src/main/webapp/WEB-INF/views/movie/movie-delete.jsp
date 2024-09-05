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
<input type="hidden" name="miNum" id="miNum" value="<%=movie.getMiNum()%>">

<table border="1">
	<tr>
		<th>번호</th>
		<td><%=movie.getMiNum()%></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" id="miName" name="miName" value="<%=movie.getMiName()%>"></td>
	</tr>
	<tr>
		<th>감독</th>
		<td><input type="text" id="miDirector" name="miDirector" value="<%=movie.getMiDirector()%>"></td>
	</tr>
	<tr>
		<th>장르</th>
		<td><input type="text" id="miGenre" name="miGenre" value="<%=movie.getMiGenre()%>"></td>
	</tr>
	<tr>
		<th>개봉일</th>
		<td><input type="text" id="miYear" name="miYear" value="<%=movie.getMiYear()%>"></td>
	</tr>
	<tr>
		<th colspan="2">
		<button>영화 삭제</button>
		</th>
	</tr>
	</table>
</form>
</body>
</html>