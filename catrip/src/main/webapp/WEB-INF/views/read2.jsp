<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 내용보기</h1>
	
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${vo.regdate }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${vo.t_content }</td>
		</tr>
	</table>
	
	<hr>
	<input type="button" value="목록" onclick="location.href='board2';">
	
</body>
</html>