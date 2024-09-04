<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 등록</title>
</head>
<body>
	<form method="POST" action="/menu/menu-insert" enctype="multipart/form-data">
		<table border ="1">
			<tr>
				<th>메뉴명</th>
				<td><input type="text" id="miName" name="miName" placeholder="메뉴명"></td>
			</tr>
			
			<tr>
				<th>가격</th>
				<td><input type="text" id="miPrice" name="miPrice" placeholder="가격"></td>
			</tr>
			
			<tr>
				<th>메뉴 소개</th>
				<td><input type="text" id="miDesc" name="miDesc" placeholder="메뉴소개"></td>
			</tr>
			
			<tr>
				<th>메뉴 사진</th>
				<td><input type="file" id="miImg" name="miImg"></td>
			</tr>
		</table>
		<button>메뉴 등록</button>
	
	</form>
</body>
</html>