<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>page include</div>
	<%@ include file="image.jsp" %>
	<hr>
	<div>jsp action include</div>
	<jsp:include page="image.jsp">
		<jsp:param name="name" value="github"/>
	</jsp:include>

</body>
</html>