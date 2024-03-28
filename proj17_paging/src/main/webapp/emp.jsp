<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>emp 목록</h1>
	<hr>
	
	<table border=1>
		<thead>
			<tr>
				<th>No.</th>
				<th>레벨</th>
				<th>사원번호</th>
				<th>이름</th>
				<th>선배</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${ not empty list }">
				<c:forEach var="vo" items="${ list }" varStatus="status">
					<tr>
						<td>${ vo.rnum }</td>
						<td>${ vo.lv }</td>
						<td>${ vo.empno }</td>
						<td style="padding-left: ${ (vo.lv - 1) * 10 }px;">
							<c:if test="${ vo.lv ne 1 }">
							ㄴ
							</c:if>
							${ vo.ename }
						</td>
						<td>${ vo.mgr }</td>
					</tr>
			</c:forEach>
			</c:if>
			<c:if test="${ not not empty list }">
				<tr>
					<td colspan="5">자료가 없습니다</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	
	<!-- 페이징 paging -->
	<div>
	<%
		int totalCount = (int) request.getAttribute("totalCount");
		int countPerPage = (int) request.getAttribute("countPerPage");
		int pageNum = (int) request.getAttribute("pageNum");
		
		int lastPage = (int) Math.ceil((double) totalCount / countPerPage);
		
		int countPerSection = 3;	// 한번에 보여줄 페이지의 개수
		int sec_position = (int) Math.ceil((double) pageNum / countPerSection);
		// 2 : 4 ~ 6
		int sec_first = (sec_position - 1) * countPerSection + 1;
		int sec_last = sec_position * countPerSection;
		// 28 : 28 ~ 30
		if(sec_last > lastPage) {
			sec_last = lastPage;
		}
	%>
		<c:set var="sec_first" value="<%= sec_first %>"/>		
		<c:set var="sec_last" value="<%= sec_last %>"/>		
		
		<c:if test="<%= sec_first != 1 %>">
			[ <a href="/proj17_paging/emp?pageNum=${ sec_first - 1 }">이전</a> ]
		</c:if>
		<c:if test="<%= sec_first == 1 %>">
			[ 이전 ]
		</c:if>
		
		<c:forEach var="i" begin="${ sec_first }" end="${ sec_last }">
			<c:choose>
				<c:when test="${ i != pageNum }">
					[ <a href="/proj17_paging/emp?pageNum=${ i }">${ i }</a> ]
				</c:when>
				<c:otherwise>
					[ <a href="/proj17_paging/emp?pageNum=${ i }"><strong>${ i }</strong></a> ]				
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="<%= sec_last != lastPage %>">
			[ <a href="/proj17_paging/emp?pageNum=${ sec_last + 1 }">다음</a> ]
		</c:if>
		<c:if test="<%= sec_last == lastPage %>">
			[ 다음 ]
		</c:if>
		
	</div>

</body>
</html>