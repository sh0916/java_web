<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	let url = "/pro29/rest/ajax";
	
	// ajax 객체 생성
	let xhr = new XMLHttpRequest();
	// 보낼 준비
	xhr.open("post", url);
	
	xhr.setRequestHeader("Content-Type", "application/json");
	let jsonData = {
			"ename" : "성현",
			"sal" : 3000
	}
	
	// 보내기(단! 언제 끝날지 모름)
	xhr.send(JSON.stringify(jsonData));
	
	// 다녀온 후(응답 이후)
	xhr.onload = function () {
	    // 받아온 내용이 저장되는 곳
	    let data = xhr.responseText;
	    console.log(data);
	
	    let json = JSON.parse(data);
	    console.log(json);
	    console.log(json.ename);
	    console.log(json["sal"]);
	}
</script>
</body>
</html>