<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="workOrder.WorkDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#bord {
		display: block;
	}
	
	#add_div {
		display: none;
	}
	
</style>
</head>
<body>

	<%
		List<WorkDTO> list = (List<WorkDTO>) request.getAttribute("list");
	%>

	<div>
		<h1>작업 지침서</h1>
		<div id="bord">
			<table>
				<tr>
					<th>제목</th>
					<th>내용</th>
					<th>작성일</th>
				</tr>
			<%
				if(list != null) {
					
					for(int i = 0; i < list.size(); i++) {
						
						int seq = list.get(i).getSeq();
						String title = list.get(i).getTitle();
						String detail = list.get(i).getDetail();
						Date hiredate = list.get(i).getHiredate();
			%>
				<tr>
					<td class="update"><%= title %></td>
					<td><%= detail %></td>
					<td><%= hiredate %></td>
					<input type="hidden" value="<%= seq %>">
				</tr>
			<%
					}
				}
			%>
			</table>
			<input type="button" value="추가하기" id="add_button">
		</div>
		<div id="add_div">
			<form method="post" action="work">
				<input type="text" name="title" placeholder="제목 입력">
				<textarea name="detail" placeholder="내용 입력"></textarea>
				<input type="hidden" name="type" value="add">
				<input type="submit" value="작성하기">
			</form>
		</div>
	</div>
	
	<script>
		
// 		document.querySelectorAll(".update")
// 				.addEventListener("click", function(event) {
					
// 					var title = parentRow.querySelector('.update').innerText; // 첫 번째 자식 요소의 텍스트 가져옴
// 			        var detail = parentRow.querySelector('td:nth-child(2)').innerText; // 두 번째 자식 요소의 텍스트 가져옴
// 			        var hiredate = parentRow.querySelector('td:nth-child(3)').innerText; // 세 번째 자식 요소의 텍스트 가져옴
// 			        var seq = parentRow.querySelector('input[type="hidden"]').value;
// 				});
		
		document.querySelector("#add_button")
				.addEventListener("click", function() {
					
					document.querySelector("#bord").style.display = "none";
					document.querySelector("#add_div").style.display = "block";
				});
	
	</script>
</body>
</html>