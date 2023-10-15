<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:if test="${empty sessionScope.id.id}">
    <c:redirect url="/login" />
</c:if>

</head>
<body>
		<h1>글쓰기</h1>
		
		ㅇㅇㅇㅇ : ${sessionScope.id.id} <br>
		ㅇㅇㅇㅇ : ${sessionScope.id} <br>
		ㅇㅇㅇㅇ : ${id }<br>
			
	    <c:set var="value" value="${param.v}" />

	    <c:if test="${value == '0'}">
	    	<fieldset>
				<form action="" method="post">
					해외 <br>
					제목 : <input type="text" name="subject" > <br>
					내용 : <input type="text" name="content"> <hr>
					<input type="hidden" name="v" value=0>
					<input type="submit" value="등록">
				</form>
			</fieldset>
	    </c:if>
	    
	    <c:if test="${value == '1'}">
	    	<fieldset>
				<form action="" method="post">
					국내 <br>
					제목 : <input type="text" name="subject"> <br>
					내용 : <input type="text" name="content"> <hr>
					<input type="hidden" name="v" value=1>
					<input type="submit" value="등록">
				</form>
			</fieldset>
	    </c:if>
	    
</body>
</html>