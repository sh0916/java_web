<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="sec02.ex01.dbcp.DbcpDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border-collapse: collapse;
}
td, th {
	border: 1px solid black;
	width: 100px;
	padding: 15px;
	text-align: center;
}

.ebery {
	display: block;
}

.detail {
	display: none;
}
</style>
</head>
<body>

	<table>
		
		<tr>
			<th>사원 번호</th>
			<th>사원 이름</th>
			<th>사원 연봉</th>
		</tr>
		<%
		List<DbcpDTO> list = (List<DbcpDTO>) request.getAttribute("list");

		if (list != null) {

			for (int i = 0; i < list.size(); i++) {
				DbcpDTO dbcpDTO = (DbcpDTO) list.get(i);
				int empno = dbcpDTO.getEmpno();
				String ename = dbcpDTO.getEname();
				int sal = dbcpDTO.getSal();
		%>

		<tr class="every">
			<td><%=empno%></td>
			<td class="info"><%=ename%></td>
			<td><%=sal%></td>
		</tr>
		<%
		}
		}
		%>
		

	</table>
	<table id="infoTable">
	
		<tr class="detail">
		</tr>
	
	</table>
	<form method="post" action="dbcp" name="retouchForm">
		<input type="text" name="empno" value="수정할 사원 번호">
		<select name="retouchSelect">
			<option>수정할 정보</option>
			<option value="ename">사원이름</option>
			<option value="job">직업</option>
			<option value="mgr">상사번호</option>
			<option value="sal">연봉</option>
			<option value="comm">보너스</option>
		</select>
		<input type="hidden" name="type" value="2">
		<input type="button" id="retouch" value="수정하기">
	</form>

	<script>
	
	let info = document.querySelectorAll(".info");
	let empno;
	
	for(let i = 0; i < info.length; i++) {
		
			info[i].addEventListener("click", (event)=> {
				
				let pare = event.target.parentElement;
				let cho = pare.firstElementChild;
				
				empno = cho.innerText;
				console.log(empno);
				
// 				let form = document.createElement("form");
// 				form.action = "dbcp";
// 				form.method = "post";
				
// 				let input = document.createElement("input");
// 				input.type = "hidden";
// 				input.name = "empno";
// 				input.value = empno;
				
// 				form.appendChild(input);
// 				document.body.appendChild(form);
				
// 				form.submit();

				let xhr = new XMLHttpRequest();
				xhr.open("post", "dbcp");
				xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				xhr.send("empno=" + empno + "&type=1");
				
				xhr.onload = function() {
					
					let data = xhr.responseText;
					console.log(data);
					
					let arr = data.split(",");
					
					let infoTable = document.querySelector("#infoTable");
// 					document.querySelector(".every").style.display = "none";
					
					let html = "";
						html += "<tr>";
						html += "<th>";
						html += "사원 번호";
						html += "</th>";
						html += "<th>";
						html += "사원 이름";
						html += "</th>";
						html += "<th>";
						html += "직업";
						html += "</th>";
						html += "<th>";
						html += "상사 번호";
						html += "</th>";
						html += "<th>";
						html += "입사일";
						html += "</th>";
						html += "<th>";
						html += "연봉";
						html += "</th>";
						html += "<th>";
						html += "보너스";
						html += "</th>";
						html += "</tr>";
					
						for(let j = 0; j < arr.length -1; j++) {
							
							let splitArr = arr[j].split("=");
							
							if(j < 7) {
								html += "<td>";
								html += splitArr[1];
								html += "</td>";
							} else {
								
								let final = splitArr[1].split("]");
								html += "<td>";
								html += final[0];
								html += "</td>";
							}
						}
							infoTable.innerHTML = html;
										
				}
				
				
				
			});
			
	}
	
		document.querySelector("#retouch")
				.addEventListener("click", ()=> {
					console.log("수정버튼눌림");
					let form = document.querySelector("[name=retouchForm]");
					console.log(form);
					
					let xhr = new XMLHttpRequest();
					
					xhr.open("post", "dbcp");
					
					let formData = new FormData(form);
					
					xhr.send(formData);
					console.log("doAjax 실행");
				});
	
	
</script>
</body>
</html>