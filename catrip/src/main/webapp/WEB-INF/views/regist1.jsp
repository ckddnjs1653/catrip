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
		<h2>해외</h2>
		<fieldset>
			<form action="" method="post">
				제목 : <input type="text" name="subject"> <br>
				나라 :  <select name="t_name">
							<option>나라를 선택하세요.</option>
								<c:forEach var="t" items="${trip}">
									<c:if test="${not empty t.t_city}">
										<option value="${t.t_name}">${t.t_name}</option>
									</c:if>
								</c:forEach>
						</select ><br> 
				도시 :  <select name="t_city">
							<option>도시를 선택하세요.</option>
								<c:forEach var="t" items="${trip}">
										<c:if test="${not empty t.t_city}">
											<option value="${t.t_city}">${t.t_city}</option>
										</c:if>
								</c:forEach>
						</select> 
				<br>
				인원수 : <input type="number" name="maxPerson" placeholder="인원수를 입력해주세요." min="2"> <br>
				내용 : <textarea rows="10" cols="20" name="content"></textarea>
				<hr>
				<input type="hidden" name="v" value="0">
				<input type="submit" value="등록">
			</form>
		</fieldset>
	</c:if>

	<c:if test="${value == '1'}">
		<fieldset>
			<form action="" method="post">
				국내 <br> 도시 : <select name="k_city" >
					<option>도시를 선택하세요.</option>
					<c:forEach var="k" items="${trip}">
						<c:if test="${not empty k.k_city}">
							<option value="${k.k_city}">${k.k_city}</option>
						</c:if>
					</c:forEach>
				</select><br> 제목 : <input type="text" name="subject"> <br>
				내용 : <textarea rows="10" cols="20" name="content"></textarea>
				<hr>
				<input type="hidden" name="v" value="1"> <input
					type="submit" value="등록">
			</form>
		</fieldset>
	</c:if>

	<hr>
</body>
</html>