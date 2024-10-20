package gr.aueb.elearn.dionChar.teacherapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// TODO: Move email and password to a secure data source.

	private static final String ADMIN_EMAIL = "dion.charalampopoulos@gmail.com";
	private static final String ADMIN_PASSWORD = "12345678"; // Plain text password (will improve)

	/**
	 * Handles login requests by checking the provided credentials. If the
	 * credentials match, it redirects to the teacher's menu page. Otherwise, it
	 * returns to the login page with an error message.
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String eMail = request.getParameter("eMail");
		String password = request.getParameter("password");

		// TODO: Use hashed passwords and a password hashing library like BCrypt.
		// TODO: Implement better input validation (email format, password strength
		// etc).

		if (eMail.equals(ADMIN_EMAIL) && (password.contentEquals(ADMIN_PASSWORD))) {
			// redirect to search page
			request.getRequestDispatcher("/jsps/teachersmenu.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "Login Error");
			request.getRequestDispatcher("/jsps/login.jsp").forward(request, response);
		}

	}

}
