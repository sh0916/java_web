<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>emp 목록</h1>
	<hr>
	
	<table border=1>
		<thead>
			<tr>
				<th>사원번호</th>
				<th>이름</th>
				<th>선배</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${ list }">
				<tr>
					<td>${ vo.empno }</td>
					<td>${ vo.ename }</td>
					<td>${ vo.mgr }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div id="paging">
		<c:forEach var="page" items="1"></c:forEach>
	</div>

</body>
</html>