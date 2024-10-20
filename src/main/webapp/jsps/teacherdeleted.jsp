<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>teacher with Id: ${requestScope.deletedTeacherId} deleted</h1>
	<a href="/TeachersWebApp/jsps/teachersmenu.jsp">Επιστροφή</a>
</body>
</html>