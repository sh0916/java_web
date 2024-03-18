<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String test = (String)request.getAttribute("cookie");
%>

	<div class="popup">
		쿠키있음
		<input type="checkbox" id="addCookie">
	</div>

<script>
	console.log(document.cookie);
	
	let name;
	let value;
	let result = "<%= test %>";
	
	document.querySelector("#addCookie")
			.addEventListener("change", function() {
				
				document.cookie = "cookie2=test2";
				
				let cookie = document.cookie.split("=");
				name = cookie[0];
				value = cookie[1];
			})
			
		console.log(result);
	if(name == result) {
		document.querySelector(".popup").style.display = "none";
	}
	
	
// // 	if(document.cookie != null) {
		
// // 		let cookie = document.cookie.split("=");
		
// // 		let name = cookie[0];
// // 		let value = cookie[1];
		
// // 		if(name != "" || value != "") {
			
			
// // 		}
// 	}
	
</script>

</body>
</html>