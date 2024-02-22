<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	String id2 = (String)request.getAttribute("id2");
	List list = (List)request.getAttribute("list");
%>
아이디 : <%= id %><br>
아이디2 : <%= id2 %><br>
리스트 사이즈 : <%= list.size() %><br>
<% 	
	for(int i = 0; i < list.size(); i++) {
%>
	<%= list.get(i) %>
<%
	}
%>

</body>
</html>