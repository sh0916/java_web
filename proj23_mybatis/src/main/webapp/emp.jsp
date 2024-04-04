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
<style>

	.ename {
		cursor: pointer;
	}
	
</style>
<script>

	window.addEventListener("load", () => {
		
		// class 를 이용해서 선택
		// let enames = document.querySelectorAll(".ename");
		// id 의 패턴을 이용해서 선택
		let enames = document.querySelectorAll("[id^=ename_]");
		// data-ename 의 패턴을 이용해서 선택
		// let enames = document.querySelectorAll("[data-ename^=ename_]");
		
		for(let i = 0; i < enames.length; i++) {
			enames[i].addEventListener("click", (event) => {
				
				/* 클릭된 요소
 				   event.target === this
 				   this : span
 				   this.parentNode : td
				*/
				console.log("enames");
				event.target.parentNode.querySelector("form").submit();
			});
		}
		
		document.querySelector("#empnoTh")
				.addEventListener("click", () => {
					
					let data = document.querySelector("#empnoTh").dataset.set;
					console.log("data : " + data);
					
					let form = document.createElement("form");
					form.method = "get";
					form.action = "/proj23_mybatis/dynamic";
					
					let input = document.createElement("input");
					input.type = "hidden";
					input.name = "sort";
					input.value = data;
					
					let typeValue = document.querySelector("[name='type']").value;
					console.log("typeValue" + typeValue)
					
					let typeInput = document.createElement("input");
					typeInput.type = "hidden";
					typeInput.name = "type";
					typeInput.value = typeValue;
					
					let keywordValue = document.querySelector("[name='keyword']").value;
					let keywordInput = document.createElement("input");
					keywordInput.type = "hidden";
					keywordInput.name = "keyword";
					keywordInput.value = keywordValue;
					
					form.appendChild(input);
					form.appendChild(typeInput);
					form.appendChild(keywordInput);
					document.body.appendChild(form);
					form.submit();
				});
		
		document.querySelector("#choBtn")
				.addEventListener("click", () => {
					
					let form = document.createElement("form");
					form.method = "get";
					form.action = "/proj23_mybatis/dynamic";
					
					let choBoxs = document.querySelectorAll(".choBox");
					for(let i = 0; i < choBoxs.length; i++) {
						if(choBoxs[i].checked) {						
							console.log(choBoxs[i].value);
							
							let input = document.createElement("input");
							input.type = "hidden";
							input.name = "empno";
							input.value = choBoxs[i].value;
							
							form.appendChild(input);
						}
					}
					
					document.body.appendChild(form);
					form.submit();
				});
	});

</script>
</head>
<body>
	
	ename : ${ ename }
	<hr>
	empno : ${ map.get("EMPNO") }
	<hr>
	empno : ${ empDTO.empno }<br>
	ename : ${ empDTO.ename }<br>
	sal : ${ empDTO.sal }
	<hr>
	<a href="/proj23_mybatis/test03/empForm.jsp">회원가입</a>
	<hr>
	<form method="get" action="dynamic">
		<select name="type">
<%-- 			<c:if test="${ type == 1 }"> --%>
<!-- 				<option value="1" selected>이름</option> -->
<%-- 			</c:if> --%>
<%-- 			<c:if test="${ type != 1 }"> --%>
<!-- 				<option value="1">이름</option> -->
<%-- 			</c:if> --%>
<%-- 			<c:if test="${ type == 2 }"> --%>
<!-- 				<option value="2" selected>연봉(이상)</option>				 -->
<%-- 			</c:if> --%>
<%-- 			<c:if test="${ type != 2 }"> --%>
<!-- 				<option value="2">연봉(이상)</option>				 -->
<%-- 			</c:if> --%>
			<option value="1" ${ type == 1 ? "selected='selected'" : "" }>이름</option>				
			<option value="2" ${ type == 2 ? "selected='selected'" : "" }>연봉(이상)</option>				
			<option value="3" ${ type == 3 ? "selected='selected'" : "" }>연봉(이하)</option>				
			<option value="4" ${ type == 4 ? "selected='selected'" : "" }>직책</option>				
			<option value="5" ${ type == 5 ? "selected='selected'" : "" }>이름+직책</option>				
		</select>
		<input type="text" name="keyword" <c:if test="${ not empty keyword }">value="${ keyword }"</c:if>>
		<input type="submit" value="검색">
	</form>
	
	<table border="1">
		<thead>
			<tr>
				<th></th>
				<th id="empnoTh" 
					<c:if test="${ sort == '1' }">
						data-set="2"
					</c:if>
					<c:if test="${ sort != '1' }">
						data-set="0"
					</c:if>>
					empno
				</th>
				<th>ename</th>
				<th>job</th>				
				<th>sal</th>
				<th>deptno</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${ not empty empList }">
				<c:forEach var="empList" items="${ empList }">
					<tr>
						<td><input class="choBox" type="checkbox" value="${ empList.empno }"></td>
						<td>${ empList.empno }</td>
						<td>
							<form method="post" action="/proj23_mybatis/param">
								<input type="hidden" name="action" value="actionDetail">
								<input type="hidden" name="empno" value="${ empList.empno }">
							</form>
							<span class="ename" id="ename_1">${ empList.ename }</span>
						</td>
						<td>${ empList.job }</td>
						<td>${ empList.sal }</td>
						<td>${ empList.deptno }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${ not not empty empList }">
				<tr>
					<td colspan="3">조회할 내용이 없습니다</td>
				</tr>
			</c:if>				
		</tbody>
	</table>
	<input id="choBtn" type="button" value="선택">

</body>
</html>