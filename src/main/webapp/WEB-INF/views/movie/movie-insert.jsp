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
<form method="POST" action="/movie/movie-insert">
<table border="1">
	<tr>
		<th>제목</th>
		<td><input type="text" id="miName" name="miName" placeholder="제목"></td>
	</tr>
	<tr>
		<th>감독</th>
		<td><input type="text" id="miDirector" name="miDirector" placeholder="감독"></td>
	</tr>
	<tr>
		<th>장르</th>
		<td><input type="text" id="miGenre" name="miGenre" placeholder="장르"></td>
	</tr>
	<tr>
		<th>개봉일</th>
		<td><input type="text" id="miYear" name="miYear" placeholder="개봉일"></td>
	</tr>
	<tr>
		<th colspan="2">
		<button>영화 등록</button>
		</th>
	</tr>
	</table>
</form>
</body>
</html>