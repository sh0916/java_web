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
<script>

</script>
</head>
<body>

	<%
		String pageName = "회원가입";
		
		if(request.getAttribute("dto") != null) {
			pageName = "회원수정";
		}
	%>

	<nav>
<%-- 		<h1>홈 > <%= pageName %></h1> --%>
		<c:if test="${ not empty dto }">
			<h1>홈 > 회원수정</h1>
		</c:if>
		<c:if test="${ empty dto }">
			<h1>홈 > 회원가입</h1>
		</c:if>
	</nav>
	<form method="post" action="/proj23_mybatis/param">
		empno : <c:if test="${ not empty dto }">
					${ dto.empno }<br>
					<input type="hidden" name="empno" value="${ dto.empno }">
				</c:if>
				<c:if test="${ empty dto }">
					<input type="text" name="empno"><br>
				</c:if>
		ename : <input type="text" name="ename" value="${ dto.ename }"><br>
		sal : <input type="text" name="sal" value="${ dto.sal }"><br>
		deptno : <input type="text" name="deptno" value="${ dto.deptno }"><br>
		<br>
		<c:if test="${ not empty dto }">
			<input type="hidden" name="action" value="actionUpdate">				
		</c:if>
		<c:if test="${ empty dto }">
			<input type="hidden" name="action" value="actionInsert">				
		</c:if>
		
<%-- 		<input type="submit" value="<%= pageName %>"> --%>
		
		<c:if test="${ not empty dto }">
			<input type="submit" value="회원수정">
		</c:if>
		<c:if test="${ empty dto }">
			<input type="submit" value="회원가입">
		</c:if>
	</form>
	<form method="post" action="/proj23_mybatis/param">
		<input type="hidden" name="empno" value="${ dto.empno }">
		<input type="hidden" name="action" value="actionDelete">	
		<input type="submit" value="회원삭제">
	</form>

</body>
</html>