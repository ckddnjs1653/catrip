<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function apply() {
		window.open("apply0", "신청하기", "top=100,left=250,width=650,height=450, location=no");
	}
</script>
</head>
<body>
	<h1>내용</h1>
		세션 아이디 : ${sessionScope.id.id} <br>
		<c:set var="value" value="${param.v}" />
		${value }
		<hr>
		<table border="1">
			<tr>
				<th>제목</th>
				<th>${b_bno.subject }</th>
			</tr>
			<tr>
				<th>작성자</th>
				<th>${b_bno.id }</th>
			</tr>
			<tr>
				<th>작성일</th>
				<th>${b_bno.b_regdate }</th>
			</tr>
			<tr>
				<th>내용</th>
				<th>${b_bno.content }</th>
			</tr>
		</table>
		<hr>
		
		<c:if test="${b_bno.id != sessionScope.id.id}">
			<input type="button" onclick="apply();" name="apply" value="신청하기">
		</c:if>
		<input type="button" value="목록" onclick="location.href='board0';">
		<c:if test="${b_bno.id == sessionScope.id.id}">
			<input type="button" value="수정하기" onclick="location.href='modify1?v=${value }&b_bno=${b_bno.b_bno}';">
			<input type="button" value="삭제하기" onclick="location.href='delete1?v=${value }&b_bno=${b_bno.b_bno}';">
		</c:if>
</body>
</html>