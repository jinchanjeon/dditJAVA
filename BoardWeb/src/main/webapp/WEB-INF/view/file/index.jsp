<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- application/x-www-form-urlencoded -->
	<form action="upload.do" method="post" enctype="multipart/form-data">
		<input type="text" name="name" value="이름"> <br>
		<input type="text" name="age" value="나이"><br>
		<input type="file" name="attachFile"><br>
		<input type="submit" value="회원등록">
	</form>
</body>
</html>