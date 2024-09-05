<%@page import="com.test.web.vo.MovieVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>영화 리스트</h2>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>감독</th>
			<th>장르</th>
			<th>개봉년도</th>
		</tr>
<%
	List<MovieVO> movies = (List<MovieVO>)request.getAttribute("movies");
	for(MovieVO movie : movies){
%>
		<tr>
			<td><%=movie.getMiNum()%></td>
			<td><a href="/movie/movie-view?miNum=<%=movie.getMiNum()%>"><%=movie.getMiName()%></a></td>
			<td><%=movie.getMiDirector()%></td>
			<td><%=movie.getMiGenre()%></td>
			<td><%=movie.getMiYear()%></td>
		</tr>
<%
}
%>
	</table>
	<a href="/views/movie/movie-insert">영화등록</a>
</body>
</html>