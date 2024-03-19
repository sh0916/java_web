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

	body {
		text-align: center;
	}

	#bord {
		display: block;
	}
	
	#add_div {
		display: none;
	}
	
	#update_div {
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
		<div id="update_div">
			<form method="post" action="work">
				<input type="text" name="title" id="update_title">
				<textarea name="detail" id="update_detail"></textarea>
				<input type="hidden" name="seq" id="update_seq">
				<input type="hidden" name="type" id="db_type" value="update">
				<input type="submit" value="수정하기">
				<input type="button" id="delete_button" value="삭제하기">
				<input type="button" value="취소하기">
			</form>
		</div>
	</div>
	
	<script>
		
		let updateChk = document.querySelectorAll(".update");
		for(let i = 0; i < updateChk.length; i++) {
			
				updateChk[i].addEventListener("click", function(event) {
					
					let parent = event.target.closest("tr");
					
					let title = parent.querySelector('.update').innerText;
			        let detail = parent.querySelector('td:nth-child(2)').innerText;
			        let seq = parent.querySelector('input[type="hidden"]').value;
			        console.log(title + detail + seq);
			        
			        document.querySelector("#update_title").value = title;
			        document.querySelector("#update_detail").innerText = detail;
			        document.querySelector("#update_seq").value = seq;
			        
			        document.querySelector("#bord").style.display = "none";
			        document.querySelector("#update_div").style.display = "block";
				});
		}
		
		document.querySelector("#delete_button")
				.addEventListener("click", function() {
					
					document.querySelector("#db_type").value = "delete";
					
					let form = document.querySelector("#update_div form");
					form.submit();
				});
		
		document.querySelector("#add_button")
				.addEventListener("click", function() {
					
					document.querySelector("#bord").style.display = "none";
					document.querySelector("#add_div").style.display = "block";
				});
		
	</script>
</body>
</html>