<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		List dataList = new ArrayList();
		dataList.add("번호0");
		dataList.add("번호1");
		dataList.add("번호2");
		dataList.add("번호3");
		dataList.add("번호4");
		dataList.add("번호5");
		dataList.add("번호6");
		dataList.add("번호7");
		dataList.add("번호8");
		dataList.add("번호9");
	%>
	dataList : <%= dataList %><br>
	<c:set var="list" value="<%= dataList %>"/>
	
	<fieldset>
		<legend>
			기냥 반복
		</legend>
		<div>
			<c:forEach var="i" begin="1" end="5">
				<strong>i : </strong>${ i }<br>
			</c:forEach>
		</div>
	</fieldset>
	
	<hr>
	
	step<br>
	<c:forEach var="i" begin="1" end="10" step="4">
		<strong>i : </strong>${ i }<br>
	</c:forEach>
	
	<hr>
	
	varStatus<br>
	<c:forEach var="i" begin="1" end="10" step="4" varStatus="loop">
		<strong>i : </strong>${ i }<br>
		loop.index : ${ loop.index }<br>
		loop.count : ${ loop.count }<br>
		loop.first : ${ loop.first }<br>
		loop.last : ${ loop.last }<br>
		<c:if test="${ not loop.last }">
		,
		</c:if>
	</c:forEach>
	
	<hr>
	
	dataList 모두 출력<br>
	<c:forEach var="data" items="${ list }">
		${ data }<br>
	</c:forEach>

	<hr>
	items 와 begin, end 같이 사용<br>
	<c:forEach var="data" items="${ list }" begin="2" end="5">
		${ data }<br>
	</c:forEach>
	
	<hr>
	end 가 items 의 개수보다 큰 경우<br>
	<c:forEach var="data" items="${ list }" begin="2" end="500">
		${ data }<br>
	</c:forEach>
	
	<hr>
	begin 이 end 보다 큰 경우<br>
	<c:forEach var="data" items="${ list }" begin="20" end="5">
		${ data }<br>
	</c:forEach>
	
	begin, end 은 음수 설정 안됨 : JspTagException<br>
	
	<hr>
	출력하는 \${ list } 는 items 에서 설정한 var="list" 를 뜻한다<br>
	<c:forEach var="list" items="${ list }">
		${ list }<br>
	</c:forEach>

</body>
</html>