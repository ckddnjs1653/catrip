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
	
	<form action="./regist1" method="get">
		<input type="submit" value="글쓰기">
	</form>
	
	<hr>
	
	<table border="1">
		<tr>
		<th>제목</th>
		<th>내용</th>
		</tr>
		<c:forEach var="bd" items="${board_list}">
		<tr>
		<td>${bd.subject }</td>
		<td>${bd.content }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>