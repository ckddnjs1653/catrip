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
			국내/외<br><input type="text" name="t_foreign" placeholder="국내/외 입력해주세요."> <br>
			나라<br><input type="text" name="t_name" placeholder="나라명을 입력해주세요."> <br>
			도시<br><input type="text" name="t_city" placeholder="도시을 입력해주세요."> <br>
			제목<br><input type="text" name="title" placeholder="제목을 입력해주세요."> <br>
			내용<br><textarea rows="10" name="t_content" placeholder="나라명 입력해주세요."></textarea> <br>
			평점<br><input type="text" name="t_score" placeholder="평점을 입력해주세요."> <br>
			위험도<br><input type="text" name="t_danger" placeholder="위험도을 입력해주세요."> <br>
			 <hr>
			
			<input type="submit" value="등록">
			<input type="button" value="목록" onclick="location.href='board2';">
		</form>
	</fieldset>
	
</body>
</html>