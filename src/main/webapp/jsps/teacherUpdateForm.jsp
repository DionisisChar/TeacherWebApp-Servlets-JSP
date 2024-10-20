<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Teacher Form</title>
<style>
table {
	width: 50%;
	margin: 50px auto;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

input[type="text"], input[type="submit"] {
	padding: 10px;
	width: 100%;
	margin: 5px 0;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>

	<form action="/TeachersWebApp/TeacherUpdateController" method="post">

		

		<table>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
			<tr>
				<td>${teacher.id}</td>
				<td>${teacher.firstName}</td>
				<td>${teacher.lastName}</td>
			</tr>
			<tr>
				
				<td><input type="hidden" name="id" value="${teacher.id}"></td>
				<td><input type="text" name="newFirstName"
					placeholder="Enter new first name"></td>
				<td><input type="text" name="newLastName"
					placeholder="Enter new last name"></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Update Teacher"></td>
			</tr>
		</table>
	</form>

</body>
</html>