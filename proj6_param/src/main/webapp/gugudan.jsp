<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="get" action="gugu">
		<input type="number" name="num">
		<input type="submit" id="gu" value="전송">
	</form>
	<div id="result">
	</div>

	<script>
	
		document.querySelector("#gu")
				.addEventListener("click", function (event) {
					
					event.preventDefault();
					
					let url = "gugu";
					url += "?";
					url += "num=" + document.querySelector("[name=num]").value;
					let xhr = new XMLHttpRequest();
					
					xhr.open("get", url);
					xhr.send();
					xhr.onload = ()=> {
						console.log(xhr.responseText);
						document.querySelector("#result").innerHTML = xhr.responseText;
					}
				})
	</script>

</body>
</html>