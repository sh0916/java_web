<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bank.BankBook" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		BankBook balance = (BankBook)request.getAttribute("balance");
		int bal = balance.getBalance();
	%>
	
	현재잔액 : <input type="text" value="<%= bal %>" readonly><br>
	<form method="post" action="bank">
		<input type="number" name="amount" placeholder="입금할금액">
		<input type="submit" value="입금"><br>
		<input type="hidden" name="type" value="deposit">
	</form>
	<form method="post" action="bank">
		<input type="number" name="amount" placeholder="출금할금액">
		<input type="submit" value="출금">
		<input type="hidden" name="type" value="withdrawal">
	</form>

</body>
</html>