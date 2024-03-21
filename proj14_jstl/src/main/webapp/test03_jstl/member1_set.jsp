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

	<c:set var="id" value="홍길동" scope="page"/>
	\${ id } : ${ id }<br>
	
	<c:set var="pwd" value="1234"/>
	\${ pwd } : ${ pwd }<br>
	
	<%
		int a = 10;
	%>
	<c:set var="a1" value="<%= a %>"/>
	\${ a1 } : ${ a1 }

</body>
</html>