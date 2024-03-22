<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String name = request.getParameter("name");
		out.println("getParameter => name : " + name);
	%>
	<br>
	<%= "표현식 name : " + request.getParameter("name") %>
	<br>
	param.name : [${ param.name }]
	<hr>
	el 의 empty 는 null 또는 길이가 0일때<br>
	<c:choose>
		<c:when test="${ empty param.name }">
			name 은 필수입니다.
		</c:when>
		<c:when test="${ param.name eq 'admin' }">
			아이고 관리자님~
		</c:when>
		<c:otherwise>
			name 은 ${ param.name }
		</c:otherwise>
	</c:choose>

</body>
</html>