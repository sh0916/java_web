<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	requestScope.addr : !${ requestScope.addr }!<br>
	addr : !${ addr }!<br>
	<hr>
	sessionScope.addr2 : !${ sessionScope.addr2 }!<br>
	addr2 : !${ addr2 }!
	<hr>
	name : !${ name }!<br>
	requestScope.name : !${ requestScope.name }!<br>
	sessionScope.name : !${ sessionScope.name }!<br>
	${ asd } : getAttribute 했는데 없는 키값이라면 null 이고 el 은 null 을 표시하지 않음

</body>
</html>