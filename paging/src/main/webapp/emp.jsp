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
				<th>사원번호</th>
				<th>이름</th>
				<th>선배</th>
			</tr>
		</thead>
		<tbody id="bord">
			<c:forEach var="vo" items="${ list }">
				<tr>
					<td>${ vo.empno }</td>
					<td>${ vo.ename }</td>
					<td>${ vo.mgr }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:forEach var="i" begin="1" end="${ totalPage }">
		<a href="#" class="pageNum">${ i }</a>
	</c:forEach>

<script>

	let pageNum = document.querySelectorAll(".pageNum");
	
	for(let i = 0; i < pageNum.length; i++) {
		pageNum[i].addEventListener("click", (event) => {
			event.preventDefault();
			
			let choPage = event.target.innerText;
			console.log(choPage);

			let xhr = new XMLHttpRequest();
			
			xhr.open("get", "emp?choPage=" + choPage, true);
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			
			xhr.send();
			xhr.onload = function() {
				
				let responseData = xhr.responseText;
				console.log(responseData);
				
				let bord = document.querySelector("#bord");
				bord.innerHTML = responseData;
			}
		});
	}
	
</script>

</body>
</html>