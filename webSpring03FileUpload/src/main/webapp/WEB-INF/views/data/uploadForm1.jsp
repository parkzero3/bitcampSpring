<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<c:if test="${logStatus == null || logStatus != 'Y' }">
	<script>
		alert("로그인 후 사용이 가능합니다.");
		location.href="/myapp/login";
	</script>
</c:if>
<div>
	<h1>자료실 글올리기 방법1 </h1>
	<form method="post" action="/myapp/fileUpload1Ok" enctype="multipart/form-data">
		제목 : <input type="text" name="title" style="width:25%"/><br/>
		글내용 : <textarea rows="20" cols="90" name="content"></textarea><br/>
		첨부파일 1 : <input type="file" name="filename1"/><br/>
		첨부파일 2 : <input type="file" name="filename2"/><br/>
		<input type="submit" value="파일올리기"/>
	</form>
</div>