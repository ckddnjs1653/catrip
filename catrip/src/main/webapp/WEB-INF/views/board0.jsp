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
	 제목 <input type="text" name="subject" placeholder="제목을 입력하세요.">
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
		<c:forEach var="bd" items="${board_list}">
		<c:if test="${bd.HM_ABR == '해외'}">
			<tr>
				<td>${bd.b_bno }</td>
				<td><a href="/read1?b_bno=${bd.b_bno}">${bd.subject }</a></td>
				<td>${bd.content }</td>
				<td>${bd.cnt }</td>
				<td>${bd.b_regdate }</td>
			</tr>
		</c:if>
		</c:forEach>
	</table>
	</form>
	
	<hr>
	
	<form action="./regist1" method="get">
		<input type="button" onclick="location.href='regist1?v=0';" value="글쓰기">
		<input type="button" value="메인" onclick="location.href='main';">
	</form>
	
	<hr>
	count : ${count }<br>
	@startPage : ${bp.startPage }<br>
	@endPage : ${bp.endPage }<br>
	@@@pageSize : ${pvo.pageSize }
	<hr>
	

	<c:if test="${count > 0}">
		<c:if test="${bp.prev}">
			<a href="/board0?page=${bp.startPage - 1}&subject=${vo.subject}">Previous</a>
		</c:if>
		<c:forEach var="i" begin="${bp.startPage}" end="${bp.endPage}"
			step="1">
			<a href="/board0?page=${i}&subject=${vo.subject}">${i}</a>
		</c:forEach>
		<c:if test="${bp.next}">
			<a href="/board0?page=${bp.endPage + 1}&subject=${vo.subject}">Next</a>
		</c:if>
	</c:if>
</body>
</html>