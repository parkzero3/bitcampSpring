<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h1> 글 등록 폼</h1>
<form action="boardWriteOk" method="post">
	제목 : <input type="text" name ="subject" style="width:70%"/><br/>
	글내용 : <textarea name ="content" style="width:70%; height:100px"></textarea>
	<input type="submit" value="등록하기"/>
</form>
</body>
</html>