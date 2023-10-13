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
	
	<form action="" method="get">
	 제목 <input type="text" name="subject" placeholder="제목을 입력하세요."> <br>
	 	<input type="submit" value="조회">
	</form>
	
	<hr>
	<form action="" method="post">
	<table border="1">
		<tr>
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>조회</th>
		<th>등록일</th>
		</tr>
		<c:if test="${count>0 }">
		<c:forEach var="bd" items="${board_list}">
		<tr>
		<td>${bd.b_bno }</td>
		<td><a href="/read1?b_bno=${bd.b_bno}">${bd.subject }</td>
		<td>${bd.content }</td>
		<td>${bd.cnt }</td>
		<td>${bd.b_regdate }</td>
		</tr>
		</c:forEach>
		</c:if>
	</table>
	</form>
	
	<hr>
	
	<form action="./regist1" method="get">
		<input type="button" onclick="location.href='regist1';" value="글쓰기">
	</form>
	
	<hr>
	count : ${count }<br>
	@startPage : ${bp.startPage }<br>
	@endPage : ${bp.endPage }<br>
	@@@pageSize : ${pvo.pageSize }
	<hr>
	

	<c:if test="${count > 0}">
		<c:if test="${bp.prev}">
			<a href="/board1?page=${bp.startPage - 1}&subject=${vo.subject}">Previous</a>
		</c:if>
		<c:forEach var="i" begin="${bp.startPage}" end="${bp.endPage}"
			step="1">
			<a href="/board1?page=${i}&subject=${vo.subject}">${i}</a>
		</c:forEach>
		<c:if test="${bp.next}">
			<a href="/board1?page=${bp.endPage + 1}&subject=${vo.subject}">Next</a>
		</c:if>
	</c:if>
</body>
</html>