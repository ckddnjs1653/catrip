<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>내용</h1>
		
		<hr>
		
		${b_bno.b_bno }<br>
		${b_bno.subject }<br>
		${b_bno.content }<br>
		${b_bno.b_regdate }<br>
		
		<hr>
		
		<input type="button" value="목록" onclick="location.href='board1';">
		<input type="button" value="수정하기" onclick="location.href='modify1?b_bno=${b_bno.b_bno}';">
		<input type="button" value="삭제하기" onclick="location.href='delete1?b_bno=${b_bno.b_bno}';">
		
		
</body>
</html>