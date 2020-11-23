<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function delcheck(){
		if (confirm("삭제 하시겠습니까?")){
			location.href="/webDbcp/boardDel?no=${vo.no}";
		}
	}	
</script>
</head>
<body>
<div>
	<ul>
		<li>번호: ${vo.no }</li>
		<li>작성자: ${vo.userid }</li>
		<li>조회수: ${vo.hit }</li>
		<li>등록일: ${vo.writedate }</li>
		<li>제목: ${vo.subject }</li>
		<li>내용 <br/>
			${vo.content }</li>
	</ul>
	<div>
		<c:if test="${userid==vo.userid }">
		<a href="/webDbcp/boardEdit?no=${vo.no }">수정</a>
		<a href="javascript:delcheck()">삭제</a>
		</c:if>
		<a href="/webDbcp/boardList">목록으로</a>
	</div>
</div>
</body>
</html>