<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Test Admin</title>
</head>
<body></body>

	<a href ="${pageContext.request.contextPath}/user/links"> Back to links </a>
	<br />
			
		<form action="<%=request.getContextPath()%>/appLogout" method="POST">
        	<input type="submit" value="Logout"/>
      	</form>
</body>
</html>