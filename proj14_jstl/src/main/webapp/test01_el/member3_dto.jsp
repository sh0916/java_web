<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"/>
	<jsp:setProperty property="*" name="m"/>
	
	m.getPwd() : <%= m.getPwd() %>
	<hr>
	\${ m } : ${ m }<br>
	\${ m.id } : ${ m.id }<br>
	\${ m["id"] } : ${ m["id"] }<br>

</body>
</html>