<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>신청하기</h1>
	
	<form action="" method="post">
		제목 : <input type="text" name="intro_title" > <br>
		내용 : <br> <textarea rows="10" cols="30" name="intro_content"></textarea> <hr>
		<input type="hidden" name="v" value=0>
		<input type="submit" value="신청하기">
	</form>
	
</body>
</html>