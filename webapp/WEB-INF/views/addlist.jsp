<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="${pageContext.request.contextPath}/guest/add" method="get">
		<table border="1">
			<tr>
				<td>이름</td>
				<td colspan="4"><input type="text" name="name"></td>
				<td colspan="2">비밀번호</td>
				<td colspan="4"><input type="password" name="password"></td>
			</tr>
			
			<tr>
				<td colspan="11"><textarea rows="4" cols="65" name="content"></textarea></td>
			</tr>
			
			<tr>
				<td colspan="11"><button type="submit">확인</button></td>
			</tr>
		</table>
		<br>
		<br>
	</form>

	<c:forEach items="${gList}" var="gVo">
		<table border="1">
			<tr>
				<td>${gVo.no}</td>
				<td colspan="2">${gVo.name}</td>
				<td colspan="6">${gVo.reg_date}</td>
				<td colspan="2"><a href="${pageContext.request.contextPath}/guest/deleteForm?no=${gVo.no}">삭제</a>
			</tr>
			
			<tr>
				<td colspan="11">${gVo.content}</td>
			</tr>
		</table>
		<br>
	</c:forEach>


</body>
</html>