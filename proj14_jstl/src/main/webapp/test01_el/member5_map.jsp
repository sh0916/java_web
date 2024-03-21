<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="memberMap" class="java.util.HashMap"></jsp:useBean>
	<%
		memberMap.put("k1", "v1");
	
		sec01.ex01.MemberBean bean = new sec01.ex01.MemberBean();
		bean.setPwd("1234");
		memberMap.put("bean", bean);
	%>
	
	\${ memberMap.k1 } : ${ memberMap.k1 }
	\${ memberMap.bean.pwd } : ${ memberMap.bean.pwd }

</body>
</html>