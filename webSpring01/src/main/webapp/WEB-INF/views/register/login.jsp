<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 로그인 폼</h1>
	<form method="post" action="/webDbcp/loginOk">
		아이디 : <input type="text" name="userid" id="userid"/> <br/>
		비밀번호 : <input type="password" name="userpwd" id="userpwd"/><br/>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>