<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Success</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: #e0f2f1; 
            color: #004d40; 
            font-family: Arial, sans-serif;
        }
        .container {
            text-align: center;
            background-color: #ffffff; 
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); 
        }
        h1 {
            color: #00796b; 
        }
        p {
            font-size: 18px;
            margin: 20px 0;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 20px 0;
            font-size: 16px;
            color: #ffffff;
            background-color: #004d40; 
            border: none;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
        }
        .button:hover {
            background-color: #00332d; 
        }
    </style>
    
    <script>
        // Redirect to teachers menu after 5 seconds
        function redirectToMenu() {
            setTimeout(function() {
                window.location.href = "/TeachersWebApp/jsps/teachersmenu.jsp";
            }, 5000);
        }
        window.onload = redirectToMenu;
    </script>
   
</head>
<body>
    <div class="container">
        <h1>Update Successful!</h1>
        <p>The teacher's information has been successfully updated.</p>
        <p><strong>ID:</strong> ${oldTeacher.id}</p>
        <p><strong>First Name:</strong> ${updatedTeacher.firstName}</p>
        <p><strong>Last Name:</strong> ${updatedTeacher.lastName}</p>
        <a class="button" href="/TeachersWebApp/jsps/teachersmenu.jsp">Go to Teacher Menu</a>
    </div>
</body>
</html>