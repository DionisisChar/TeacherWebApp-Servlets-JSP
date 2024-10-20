<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>

<!--  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/form.css">
    -->
<link rel="stylesheet" href="/TeachersWebApp/static/css/login.css">
</head>
<body>

	<div class="credentials-container">
		<h3>Please copy the credentials below to log in:</h3>
		<div class="credential-item">
			<label>Email:</label> <input type="text" value="dion.charalampopoulos@gmail.com"
				readonly>
		</div>
		<div class="credential-item">
			<label>Password:</label> <input type="text" value="12345678"
				readonly>
		</div>
	</div>

	<div class="container-fluid">
		<div class="container">
			<div class="row">
				<h1 class="text-black">Login</h1>
			</div>
			<form method="POST" action="/TeachersWebApp/LoginController">
				<div class="row">
					<input type="email" name="eMail" required placeholder="E-mail">
					<span></span>
				</div>
				<div class="row">
					<input type="password" name="password" required
						placeholder="Password" pattern="(?=.*\d)[A-Za-z\d]{8,}"
						title="Must be at least 8 characters long and contain at least one number">
					<span></span>
				</div>
				<div class="row">
					<button type="submit">Sign In</button>
				</div>
			</form>
			<div class="row text-grey">
				<a href="#">Lost your password?</a>
			</div>

			<div style="color: red">
				<br> ${error}
			</div>

		</div>

		<div class="row">
			<p>
				Don't have an account? <a href="#">Sign up here!</a>
			</p>
		</div>



	</div>



</body>
</html>