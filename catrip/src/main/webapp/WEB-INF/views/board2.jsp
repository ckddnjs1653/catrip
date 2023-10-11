<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여행지 게시판</h1>

	<table border="1">
			<tr>
				<th>제목</th>
				<th>내용</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="vo" items="${boardList }">
				<tr>
					<td><a href="/read2?bno=${vo.t_bno }">${vo.title }</a></td>
					<td>${vo.t_content }</td>
					<td>${vo.viewcnt }</td>
					<td>${vo.regdate }</td>
				</tr>
			</c:forEach>
	</table>	
	
	<hr>
	
	<form action="./board2">
		<input type="button" value="글쓰기" onclick="location.href='regist2';">
		<input type="button" value="메인" onclick="location.href='main';">
	</form>
	
	
</body>
</html>