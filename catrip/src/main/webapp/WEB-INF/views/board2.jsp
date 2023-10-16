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
	
	<form action="" method="get">
		제목 <input type="text" name="title" placeholder="제목을 입력하세요.">
	 	<input type="submit" value="조회">
	</form>
	<br>
	<table border="1">
			<tr>
				<th>번호</th>
				<th>국내/외</th>
				<th>나라</th>
				<th>도시</th>
				<th>제목</th>
				<th>내용</th>
				<th>평점</th>
				<th>위험도</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		<c:forEach var="vo" items="${boardList}">
			<tr>
				<td>${vo.t_bno}</td>
				<td>${vo.t_foreign}</td>
				<td>${vo.t_name}</td>
				<c:choose>
					<c:when test="${vo.t_foreign == '국내'}">
						<td>${vo.k_city}</td>
					</c:when>
					<c:when test="${vo.t_foreign == '해외'}">
						<td>${vo.t_city}</td>
					</c:when>
				</c:choose>
				<td><a href="/read2?bno=${vo.t_bno}">${vo.title}</a></td>
				<td>${vo.t_content}</td>
				<td>${vo.t_score}</td>
				<td>${vo.t_danger}</td>
				<td>${vo.viewcnt}</td>
				<td>${vo.regdate}</td>
			</tr>
		</c:forEach>
	</table>	
	<hr>
	<c:if test="${count > 0}">
		<c:if test="${bp.prev}">
			<a href="/board2?page=${bp.startPage - 1}&title=${vo.title}">Previous</a>
		</c:if>
		<c:forEach var="i" begin="${bp.startPage}" end="${bp.endPage}"
			step="1">
			<a href="/board2?page=${i}&title=${vo.title}">${i}</a>
		</c:forEach>
		<c:if test="${bp.next}">
			<a href="/board2?page=${bp.endPage + 1}&title=${vo.title}">Next</a>
		</c:if>
	</c:if>
	<hr>
	
	<form action="./board2">
		<input type="button" value="글쓰기" onclick="location.href='regist2';">
		<input type="button" value="메인" onclick="location.href='main';">
	</form>
	
	
</body>
</html>