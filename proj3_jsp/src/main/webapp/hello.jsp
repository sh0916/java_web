<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.ArrayList" 
    import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int a = 10;

	for(int i = 0; i < 3; i++) {
%>
		<h1>Hello JSP</h1>
<%
	}
%>

<%
	out.println("<h2>subject</h2>");
%>

<%!
	// <%! => 필드 영역에 올라간다
	int b = 5;
	void test() {
		// 메소드
	}
%>

<!-- html 주석 -->
<%-- jsp 주석 --%>

	a : <% out.println(a); %><br>
	<%-- <%= => 변수값을 바로 출력해줄수있다 --%>
	a : <%= a %><br>
	
	
	<hr>
<%
	String id = request.getParameter("id");
%>
id : <input type="text" value = "<%= id %>"><br>
</body>
</html>