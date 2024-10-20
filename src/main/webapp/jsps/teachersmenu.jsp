<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teachers Search</title>
<link rel="stylesheet"
	href="/TeachersWebApp/static/css/teachersmenu.css">
</head>
<body>
	<div class="center">

		<div class="search-wrapper">
			<div class="bot-gap">
				<span class="title">Teachers Search</span>
			</div>
			<div class="bot-gap">
				<form method="GET" action="/TeachersWebApp/TeacherSearchController">
					<input name="searchInput" type="text" class="search rounded"
						placeholder="Insert teacher's lastname" autofocus /> <br> <br>
					<button class="search-btn rounded color-btn" type="submit">Search</button>
				</form>
			</div>
		</div>

		<div class="insert-wrapper">
			<div class="bot-gap">
				<span class="title">Teachers Insert</span>
			</div>
			<div class="bot-gap">
				<form method="POST" action="/TeachersWebApp/TeacherInsertController">
					<input name="id" type="text" required="required"
						class="insert rounded" placeholder="Id" autofocus /><br> <input
						name="lastName" type="text" maxlength="40"
						pattern="[a-zA-Z]+" required="required"
						class="insert rounded" placeholder="Last name"
						autofocus /><br> <input name="firstName" type="text"
						maxlength="40" pattern="[a-zA-Z]+" required="required"
						class="insert rounded" placeholder="First name" autofocus /> <br>
					<br>
					<button class="search-btn rounded color-btn" type="submit">Insert</button>
				</form>
			</div>
		</div>



		<!--  
        <div class="insert-wrapper">
	        <div class="wrapper-insert-btn rounded">
	            <a class="insert-link" href="#">Insert Teacher</a>
	        </div>
	    </div>
	    -->


	</div>
</body>
</html>

