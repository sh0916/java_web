<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>사원번호</th>
			<th>사원이름</th>
			<th>사원직무</th>
			<th>사원급여</th>
		</tr>
			<c:forEach var="info" items="${ list }">
				<tr>
					<td>${ info.empno }</td>
					<td>${ info.ename }</td>
					<td>${ info.job }</td>
					<td>${ info.sal }</td>
				</tr>
			</c:forEach>
	</table>

</body>
</html>