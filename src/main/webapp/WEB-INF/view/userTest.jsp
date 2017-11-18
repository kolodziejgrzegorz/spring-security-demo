<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>User</title>
</head>
<body></body>

		<a href="${pageContext.request.contextPath}/user/links"> Back to links </a>
		<br />
		
		<sec:authorize access="hasRole('ADMIN')">

		<a href="${pageContext.request.contextPath}/admin/adminTest"> Admin Mode </a>
		<br />

		</sec:authorize>
		
		<form action="<%=request.getContextPath()%>/appLogout" method="POST">
        	<input type="submit" value="Logout"/>
      	</form>
</body>        
</html>