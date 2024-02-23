<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	context : ${ application }<br>
	session : ${ session }<br>
	request : [${ request }]<br>
	<hr>
	members : ${ members }<br>
	member1 : ${ members[0] }<br>
	member1-ename : ${ members[0].ename }<br>
	member1-empno : ${ members[0]["empno"] }<br>

<script>
	let a = 10;
	console.log("123");
	console.log(`asd`);
	console.log(`\${a}`);
</script>

</body>
</html>