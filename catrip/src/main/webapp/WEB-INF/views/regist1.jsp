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
				해외 <br> 제목 : <input type="text" name="subject"> <br>
				나라 : <select>
					<option>나라를 선택하세요.</option>
					<c:forEach var="t" items="${trip}">
						<c:if test="${not empty t.t_city}">
							<option>${t.t_name}</option>
						</c:if>
					</c:forEach>
				</select><br> 도시 : <select>
					<option>도시를 선택하세요.</option>
					<c:forEach var="t" items="${trip}">
						<c:if test="${not empty t.t_city}">
							<option>${t.t_city}</option>
						</c:if>
					</c:forEach>
					<br>
				</select> 내용 : <input type="text" name="content">
				<hr>
				<input type="hidden" name="v" value="0"> <input
					type="submit" value="등록">
			</form>
		</fieldset>
	</c:if>

	<c:if test="${value == '1'}">
		<fieldset>
			<form action="" method="post">
				국내 <br> 도시 : <select>
					<option>도시를 선택하세요.</option>
					<c:forEach var="k" items="${trip}">
						<c:if test="${not empty k.k_city}">
							<option>${k.k_city}</option>
						</c:if>
					</c:forEach>
				</select><br> 제목 : <input type="text" name="subject"> <br>
				내용 : <input type="text" name="content">
				<hr>
				<input type="hidden" name="v" value="1"> <input
					type="submit" value="등록">
			</form>
		</fieldset>
	</c:if>

	<hr>
	    ${trip }
<%-- 	    이름 : ${trip.t_name }<br> --%>
<%-- 	   	t_도시 : ${trip.t_city }<br> --%>
<%-- 	   	k_도시 : ${trip.k_city }<br> --%>
</body>
</html>