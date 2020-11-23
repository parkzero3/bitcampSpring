<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
<h1>
	Hello world!  
</h1>

	<P> 
	<pre>
		 1. 한글 인코딩 <br/>
		 2. pom.xml <br/>
		 3. ojdbc6.jar <br/>
		 4. servlet.context.xml <br/>
		 5. Constants  클래스생성 <br/>
		 6. HomeController에 Template 생성 <br/>
		
		파일 업로드 프레임워크 구하기 
		
		commons- fileupload , commons-io 를 pom.xml에 Dependency 한다.
		root-context.xml 에 MultpartResolver객체를 생성하고
		web.xml 에 있는 DispacherServlet에 root-context.xml한다.
	</pre>
	 </P>
 </div>
</body>
</html>
