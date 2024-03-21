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
		request.setAttribute("addr", "천안시");
		session.setAttribute("addr2", "동남구");
		
		request.setAttribute("name", "리퀘스트");
		session.setAttribute("name", "세션");
	
		String url = "member2_request.jsp";
	
		request.setAttribute("url2", url);
	%>
	<jsp:forward page="<%= url %>"/>

<%-- 		<jsp:forward page="${ url2 }"/> --%>

<%-- 		<jsp:forward page="${ <%= url %> }"/> --%> <!-- 같이 사용할수 없다 -->

</body>
</html>