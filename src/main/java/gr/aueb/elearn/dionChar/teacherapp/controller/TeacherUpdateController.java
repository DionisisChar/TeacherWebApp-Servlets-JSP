package gr.aueb.elearn.dionChar.teacherapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.elearn.dionChar.teacherapp.dto.TeacherDTO;
import gr.aueb.elearn.dionChar.teacherapp.dao.ITeacherDAO;
import gr.aueb.elearn.dionChar.teacherapp.dao.TeacherDAOImpl;
import gr.aueb.elearn.dionChar.teacherapp.service.ITeacherService;
import gr.aueb.elearn.dionChar.teacherapp.service.TeacherServiceImpl;
import gr.aueb.elearn.dionChar.teacherapp.service.exception.TeacherNotFoundException;

/**
 * Servlet implementation for handling teacher update requests.
 * <p>
 * This servlet processes HTTP requests for updating teacher information. It
 * supports both GET and POST methods:
 * <ul>
 * <li>GET: Displays the update form with the current teacher's
 * information.</li>
 * <li>POST: Processes the form submission to update the teacher's
 * information.</li>
 * </ul>
 * </p>
 * 
 * <p>
 * URL pattern: /TeacherUpdateController
 * </p>
 * 
 * @see HttpServlet
 * @see TeacherDTO
 * @see ITeacherService
 */

public class TeacherUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Handles GET requests to display the update form for a teacher.
	 * <p>
	 * Retrieves the teacher's details based on the provided ID and forwards the
	 * request to the update form JSP page.
	 * </p>
	 * 
	 * @param request  The HttpServletRequest object that contains the request data.
	 * @param response The HttpServletResponse object used to send the response.
	 * @throws ServletException If an error occurs during request forwarding.
	 * @throws IOException      If an input or output error occurs.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ITeacherDAO teacherDAO = new TeacherDAOImpl();
		ITeacherService teacherService = new TeacherServiceImpl(teacherDAO);
		try {
			response.setContentType("text/html");
			Integer id = Integer.parseInt(request.getParameter("id"));

			TeacherDTO retrievedTeacher = teacherService.getTeacherById(id);
			request.setAttribute("teacher", retrievedTeacher);
			request.getRequestDispatcher("/jsps/teacherUpdateForm.jsp").forward(request, response);

		} catch (SQLException e1) {
			e1.printStackTrace();

		} catch (TeacherNotFoundException e2) {
			response.getWriter().write("<h1 style=\"color:red\">Teacher does not exist</h1>");
			request.getRequestDispatcher("/jsps/teachers.jsp").include(request, response);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Handles POST requests to update the teacher's information.
	 * <p>
	 * Processes the form submission to update the teacher's details. After
	 * updating, it forwards the request to a success page.
	 * </p>
	 * 
	 * @param request  The HttpServletRequest object that contains the form data.
	 * @param response The HttpServletResponse object used to send the response.
	 * @throws ServletException If an error occurs during request processing.
	 * @throws IOException      If an input or output error occurs.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ITeacherDAO teacherDAO = new TeacherDAOImpl();
		ITeacherService teacherService = new TeacherServiceImpl(teacherDAO);

		response.setContentType("text/html");
		Integer id = Integer.parseInt(request.getParameter("id"));
		String newLastName = request.getParameter("newLastName");
		String newFirstName = request.getParameter("newFirstName");

		TeacherDTO oldTeacher;

		try {
			oldTeacher = teacherService.getTeacherById(id);

			if (oldTeacher == null) {
				response.getWriter().write("<h1 style=\"color:red\">Teacher does not exist</h1>");
				request.getRequestDispatcher("/jsps/teachers.jsp").include(request, response);
				return;
			}

			TeacherDTO newTeacher = new TeacherDTO(id, newFirstName, newLastName);
			teacherService.updateTeacher(oldTeacher, newTeacher);

			request.setAttribute("updatedTeacher", newTeacher);
			request.setAttribute("oldTeacher", oldTeacher);
			request.getRequestDispatcher("/jsps/teacherupdated.jsp").forward(request, response);

		} catch (IllegalArgumentException e) {
			// Handle validation errors (e.g., firstName or lastName is null or too long)
			response.getWriter().write("<h1 style=\"color:red\">" + e.getMessage() + "</h1>");
			request.getRequestDispatcher("/jsps/teachermenu.jsp").include(request, response);

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();

		} catch (TeacherNotFoundException e2) {
			response.getWriter().write("<h1 style=\"color:red\">Teacher does not exist</h1>");
			request.getRequestDispatcher("/jsps/teachers.jsp").include(request, response);
			e2.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
