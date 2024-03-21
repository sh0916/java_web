<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	request.getParameter("id")를 el 로 간략하게 표현<br>
	\${ param.id } : [${ param.id }]<br>
	\${ param["id"] } : [${ param["id"] }]<br>

</body>
</html>