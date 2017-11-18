<html>
    <head>
        <title>Acces denied</title>
    </head>
    <body>
      <h3>You are not authorized to access this page</h3>
      	<br />
      <a href="${pageContext.request.contextPath}/user/links"> Back to links </a>
		<br />
      <form action="<%=request.getContextPath()%>/appLogout" method="POST">
        <input type="submit" value="Logout"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
      </form> 
    </body>
</html> 