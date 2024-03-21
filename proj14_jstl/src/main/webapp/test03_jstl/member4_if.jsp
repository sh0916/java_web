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

	<c:set var="id" value="성현"/>
	<c:set var="age" value="23"/>
	
	\${ id == 'hong' } : ${ id == 'hong' }<br>
<%-- 	<c:if test="${ id == 'hong' }"> --%>
	<c:if test="${ id eq 'hong' }">
		${ id }님 안녕하세요<br>
	</c:if>
	
<%-- 	<c:if test="${ (id eq 'hong') && (age eq 23) }"> --%>
	<c:if test="${ (id eq 'hong') and (age eq '23') }">
		${ id }님 나이는 ${ age }입니다<br>
	</c:if>
	
<%-- 	<c:if test="${ age > 20 }"> --%>
	<c:if test="${ age gt 20 }" var="result">
		age 가 20 보다 큽니다<br>
	</c:if>
	
	${ 'accd' > 'abzz' } : 앞 글자부터 하나씩 비교<br>
	${ 'aa' < 'aaa' } : 둘다 같으면 글자수로 비교
	
	<hr>
	c:else 가 없다 .. 그렇다면!!
	
	<c:if test="${ id eq '성현' }" var="result">
		id 가 성현 입니다<br>
	</c:if>
	
	<c:if test="${ !result }">
		id 가 성현 이 아닙니다<br>
	</c:if>

</body>
</html>