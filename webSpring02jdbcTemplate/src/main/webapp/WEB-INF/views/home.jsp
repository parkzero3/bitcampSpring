<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
<link rel="stylesheet" href="/webDbcp/css/boardStyle.css" type="text/css">
</head>
<body>
<h1>
	JDBC Template
</h1>

<ul>
	<li>
		<c:if test="${logStatus==null || logStatus!='Y' }">
			<h2><a href="/temp/login">로그인</a></h2>
		</c:if>
		<c:if test="${logStatus!=null && logStatus=='Y' }">
			<h2><a href="/temp/logout">로그아웃</a></h2>
		</c:if>
	</li>
	 <li><h2><a href="/temp/boardList">게시판</a></h2></li>
</ul>
</body>
</html>
