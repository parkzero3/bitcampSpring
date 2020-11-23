<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:if test="${result>0 }">
	<script>
		alert("글이 수정되었습니다.");
		location.href="/temp/boardView?no=${no}";
	</script>
</c:if>

<c:if test="${result <=0 }">
	<script>
		alert("글 수정 실패");
		history.back();
	</script>
</c:if>