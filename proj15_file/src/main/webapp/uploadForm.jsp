<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="upload.do" enctype="multipart/form-data" accept-charset="utf-8">
		파일 1 : <button type="button" id="btn1">파일1
		</button><input type="file" name="file1" id="file1" style="display:none;"><br>
		파일 2 : <input type="file" name="file2"><br>
		<br>
		매개변수 1 : <input type="text" name="param1"><br>
		매개변수 2 : <input type="text" name="param2"><br>
		매개변수 3 : <input type="text" name="param3"><br>
		<br>
		<input type="submit" value="업로드">
	</form>

<script>

	document.querySelector("#btn1")
			.addEventListener("click", () => {
				document.querySelector("#file1").click();				
			});
</script>

	<img src="http://localhost:8080/proj15_file/download.do?fileName=1711435730674_dog.jpg">

</body>
</html>