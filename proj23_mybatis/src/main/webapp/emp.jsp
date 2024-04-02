<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	ename : ${ ename }
	<hr>
	empno : ${ map.get("EMPNO") }
	<hr>
	empno : ${ empDTO.empno }<br>
	ename : ${ empDTO.ename }<br>
	sal : ${ empDTO.sal }
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<th>empno</th>
				<th>ename</th>
				<th>deptno</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${ not empty empList }">
				<c:forEach var="empList" items="${ empList }">
					<tr>
						<td>${ empList.empno }</td>
						<td>${ empList.ename }</td>
						<td>${ empList.deptno }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${ not not empty empList }">
				<tr>
					<td colspan="3">조회할 내용이 없습니다</td>
				</tr>
			</c:if>				
		</tbody>
	</table>

</body>
</html>