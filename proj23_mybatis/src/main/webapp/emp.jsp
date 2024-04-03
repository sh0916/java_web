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
<style>

	.ename {
		cursor: pointer;
	}
	
</style>
<script>

	window.addEventListener("load", () => {
		
		// class 를 이용해서 선택
		// let enames = document.querySelectorAll(".ename");
		// id 의 패턴을 이용해서 선택
		let enames = document.querySelectorAll("[id^=ename_]");
		// data-ename 의 패턴을 이용해서 선택
		// let enames = document.querySelectorAll("[data-ename^=ename_]");
		
		for(let i = 0; i < enames.length; i++) {
			enames[i].addEventListener("click", (event) => {
				
				/* 클릭된 요소
 				   event.target === this
 				   this : span
 				   this.parentNode : td
				*/
				console.log("enames");
				event.target.parentNode.querySelector("form").submit();
			});
		}
	});

</script>
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
	<a href="/proj23_mybatis/test03/empForm.jsp">회원가입</a>
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
						<td>
							<form method="post" action="/proj23_mybatis/param">
								<input type="hidden" name="action" value="actionDetail">
								<input type="hidden" name="empno" value="${ empList.empno }">
							</form>
							<span class="ename" id="ename_1">${ empList.ename }</span>
						</td>
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