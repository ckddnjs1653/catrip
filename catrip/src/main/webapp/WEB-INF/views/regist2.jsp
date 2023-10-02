<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여행지 글쓰기</h1>
	
	<fieldset>
		<form action="" method="post">
			제목<br><input type="text" name="title" placeholder="제목을 입력해주세요."> <br>
			내용<br><textarea rows="10" name="t_content" placeholder="내용을 입력해주세요."></textarea> <hr>
			
			<input type="submit" value="글쓰기">
			<input type="button" value="목록" onclick="location.href='board2';">
		</form>
	</fieldset>
	
</body>
</html>