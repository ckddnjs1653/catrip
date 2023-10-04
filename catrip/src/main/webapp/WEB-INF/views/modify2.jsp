<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 수정하기</h1>
	<fieldset>
		<form action="/modify2" method="post">
			제목<br><input type="text" name="title" value="${vo.title }"> <br>
			내용<br><textarea rows="10" name="t_content">${vo.t_content }</textarea> <hr>
			<input type="hidden" name="bno" value="${vo.t_bno}">
			<input type="submit" value="수정">
			<input type="button" value="목록" onclick="location.href='board2';">
		</form>
	</fieldset>
	
</body>
</html>