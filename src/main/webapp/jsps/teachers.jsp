<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Teachers List</title>
    <link rel="stylesheet" href="/TeachersWebApp/static/css/teachers.css">
</head>
<body>

	<table class="table-container">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Delete</th>
			<th>Update</th>

		</tr>

		<c:forEach var="teacher" items="${teachers}">
			<tr>
				<td>${teacher.id}</td>
				<td>${teacher.firstName}</td>
				<td>${teacher.lastName}</td>
				<td><a
					href="/TeachersWebApp/TeacherDeleteController?id=${teacher.id}">Delete</a></td>
				<td><a
					href="/TeachersWebApp/TeacherUpdateController?id=${teacher.id}">Update</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>
