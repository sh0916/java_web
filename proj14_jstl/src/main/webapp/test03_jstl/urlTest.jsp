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

	<h1>c:url 을 쓰는 이유</h1>
	1. 영어나 숫자 외의 한글이나 특수문자를 encode 해줌<br>
	2. context path 자동 추가(/proj14_jstl)<br>
	3. 쿠키 금지일때 : jsessionid= 를 자동으로 붙여줌<br>
	
	<a href="https://search.naver.com/search.naver?query=검색" target="_blank">네이버 검색</a>
	
	<hr>
	원래는 /부터 사용하려면<br>
	<a href = "/proj14_jstl/test03_jstl/member1_set.jsp" target="_blank">member1 로 이동</a>
	
	<hr>
	<c:url var="url1" value="/test03_jstl/member5_choose.jsp">
		<c:param name="name" value="홍길동"/>
	</c:url>
	<a href="${ url1 }">member5 로 이동</a>

</body>
</html>