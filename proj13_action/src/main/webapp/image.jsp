<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<img style="width: 100px; height: 100px;" src="https://cdn.icon-icons.com/icons2/3398/PNG/512/github_logo_icon_214756.png">
	
	<div>
		이미지 이름 : <%= request.getParameter("name") %>
	</div>
	
</body>
</html>