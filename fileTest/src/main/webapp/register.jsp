<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="login" enctype="multipart/form-data" accept-charset="utf-8">
		아이디 : <input type="text" name="userId"><br>
		비밀번호 : <input type="text" name="userPass"><br>
		프로필사진 : <input type="file" name="userImg"><br>
		사진이름 : <input type="text" name="imgName"><br>
		<input type="submit" value="회원가입">
	</form>

</body>
</html>