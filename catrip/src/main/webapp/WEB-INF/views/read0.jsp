<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">
	function apply(b_bno) {
		window.open("apply0?b_bno=" + b_bno, "신청하기", "top=100,left=250,width=650,height=450, location=no");
        window.close();
	}
	
	function apply0(id, b_bno) {
		if (confirm(id + "님을 승인하시겠습니까?")) {
			$.ajax({
				url: "/read0",
                type: "POST",
                data: {
                    id: id,
                    b_bno: b_bno
                },
                success: function () {
                	alert("승인되었습니다.");
                	window.location.reload();
                },
                error: function () {
                	alert("에러남");
                }
            });
			
		}
	}
	
	function apply00() {
		alert("이미 최대 인원수입니다.")
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
			<input type="button" onclick="apply(${b_bno.b_bno});" name="apply" value="신청하기">
		</c:if>
		<input type="button" value="목록" onclick="location.href='board0';">
		<c:if test="${b_bno.id == sessionScope.id.id}">
			<input type="button" value="수정하기" onclick="location.href='modify1?v=${value }&b_bno=${b_bno.b_bno}';">
			<input type="button" value="삭제하기" onclick="location.href='delete1?v=${value }&b_bno=${b_bno.b_bno}';">
		</c:if>
		
		<c:if test="${b_bno.id == sessionScope.id.id}">
			<hr>
			<h2>신청자 목록</h2>
			인원수 : ${b_bno.personNum }/${b_bno.maxPerson }
			<table border="1">
				<tr>
					<th>신청자</th>
					<th>제목</th>
					<th>승인여부</th>
				</tr>
				<c:forEach var="apply" items="${apply }">
					<tr>
						<th>${apply.id }</th>
						<th>${apply.intro_title }</th>
						<c:choose>
							<c:when test="${b_bno.maxPerson == b_bno.personNum }">
								<th><input type="button" value="승인" onclick="apply00();"></th>
							</c:when>
							<c:when test="${apply.apply == '0' and b_bno.maxPerson gt b_bno.personNum }">
								<th><input type="button" value="승인" onclick="apply0('${apply.id}', '${b_bno.b_bno}');"></th>
							</c:when>
							<c:when test="${apply.apply}">
								<th>승인완료</th>
							</c:when>
						</c:choose>
					</tr>
				</c:forEach>
			</table>
		</c:if>
</body>
</html>