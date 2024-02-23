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
	ServletContext ctx = getServletContext();
	String ctxValue = (String)ctx.getAttribute("application");
	String sessValue = (String)session.getAttribute("session");
	String reqValue = (String)request.getAttribute("request");
	String appValue = (String)application.getAttribute("application");
%>

	context : <%= ctxValue %><br>
	session : <%= sessValue %><br>
	request : <%= reqValue %><br>
	appValue : <%= appValue %><br>

</body>
</html>