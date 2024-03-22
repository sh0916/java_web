<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	new Date() : <%= new Date() %><br>
	<c:set var="now" value="<%= new Date() %>"/>
	
	<fmt:formatDate value="${ now }" pattern="yyyy년 MM월 dd일 a HH:mm:ss"/>

</body>
</html>