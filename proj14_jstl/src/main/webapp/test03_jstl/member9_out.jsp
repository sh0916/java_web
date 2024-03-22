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

	a 태그로 입력해보기<br>
	
	param.id : ${ param.id }<br>
	<c:out value="asdf"/><br>
	
	특수문자를 치환해서 문자 그자체로 출력되게 해줌
	<c:out value="${ param.id }"/><br>
	
	< &it;
	> &gt;
	& &amp;
	" "(공백문자) : &nbsp;

</body>
</html>