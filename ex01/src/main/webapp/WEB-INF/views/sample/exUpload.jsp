<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>업로드</h1>

<form action="sample/ExuploadPost" method="post" enctype="multipart/form-data">
<div><input type="file" name="files"></div>
<div><input type="file" name="files"></div>
<div><input type="file" name="files"></div>
<div><input type="file" name="files"></div>
<div><input type="file" name="files"></div>

<div><input type="submit" name="전송"></div>
</form>
</body>
</html>