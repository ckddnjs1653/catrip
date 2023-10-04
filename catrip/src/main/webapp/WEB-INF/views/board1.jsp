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
	<h1>게시판</h1>
	
	
	
	<table border="1">
		<tr>
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>조회</th>
		<th>등록일</th>
		</tr>
		<c:forEach var="bd" items="${board_list}">
		<tr>
		<td>${bd.b_bno }</td>
		<td><a href="/read1?b_bno=${bd.b_bno}">${bd.subject }</td>
		<td>${bd.content }</td>
		<td>${bd.cnt }</td>
		<td>${bd.b_regdate }</td>
		</tr>
		</c:forEach>
	</table>
	
	
	<hr>
	
	<form action="./regist1" method="get">
		<input type="submit" value="글쓰기">
	</form>
	
	<hr>
</body>
</html>