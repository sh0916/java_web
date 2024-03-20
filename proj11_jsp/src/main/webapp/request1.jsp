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
		request.setAttribute("name", "성현");
		request.setAttribute("adr", "천안");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("request2.jsp");
		dispatcher.forward(request, response);
	%>

</body>
</html>