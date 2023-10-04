<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 글 수정하기 </h1>
	
	<form action="" method="post">
	
	제목 : <input type="text" name="subject" value=${vo.subject }> <br>
	내용 : <input type="text" name="content" value=${vo.content }> <br>
	<hr>
	<button type="submit" >수정완료</button>
	</form>
	
	
	
	
</body>
</html>