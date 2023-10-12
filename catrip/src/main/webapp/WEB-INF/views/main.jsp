<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>caTrip</title>
</head>
<body>
	<h1>caTrip 메인</h1>

	<form action="./join" method="get">
		<input type="submit" value="회원가입">
	</form>
	
	<hr>
	
	<form action="./board2">
		<input type="button" value="게시판2" onclick="location.href='board2';">
	</form>

	<hr>
	
	<form action="./board1" method="get">
		<input type="submit" value="게시판">
	</form>
	
	<hr>
	
	<form action="./logout" method="get">
		<input type="submit" value="로그아웃">
	</form>
</body>
</html>