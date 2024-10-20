<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Επιτυχής Εισαγωγή</title>
</head>
<body>
	<p>	Teacher: ${insertedTeacher.id} <br>
	 	${insertedTeacher.lastName} <br>
	 	${insertedTeacher.firstName} <br>
	   	successfully inserted!
	
	<a href="/TeachersWebApp/jsps/teachersmenu.jsp">Επιστροφή</a>

</body>
</html>