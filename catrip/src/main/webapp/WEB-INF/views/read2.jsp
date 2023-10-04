<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function () {
		$("#delete2").click(function() { 
			let obj = { bno: $("#delete2").val() };
			$.ajax({
				url: "/delete2",
				type: "POST",
				data: obj,
				success: function() {
	                window.location.href = "/board2";
	            },
	            error: function() {
	                alert("실패실패");
	            }
			});
		});
	});
</script>
</head>
<body>
	<h1>글 내용보기</h1>
	
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${vo.viewcnt }</td>
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
	<input type="button" value="수정" onclick="location.href='modify2?bno=${vo.t_bno }';">
	<button id="delete2" name="delete2" value="${vo.t_bno }">삭제</button>
	
</body>
</html>