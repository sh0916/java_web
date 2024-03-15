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
	System.out.println(session.getId());
	String sessionId = (String)session.getAttribute("session");
	System.out.println("sessionId : " + sessionId);
	
	HttpSession sessionFalse = request.getSession(false);

	if(sessionId == null || session.getId().equals(sessionId) != true) {
		
		response.sendRedirect("login.html");
	}
%>
	메인페이지겠냐고ㅋㅋ

</body>
</html>