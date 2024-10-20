package gr.aueb.elearn.dionChar.teacherapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.elearn.dionChar.teacherapp.dto.TeacherDTO;
import gr.aueb.elearn.dionChar.teacherapp.service.exception.TeacherIdAlreadyExistsException;
import gr.aueb.elearn.dionChar.teacherapp.service.ITeacherService;
import gr.aueb.elearn.dionChar.teacherapp.service.TeacherServiceImpl;
import gr.aueb.elearn.dionChar.teacherapp.dao.ITeacherDAO;
import gr.aueb.elearn.dionChar.teacherapp.dao.TeacherDAOImpl;

/**
 * Servlet implementation class TeacherInsertController
 */
public class TeacherInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Handles the POST request to insert a new Teacher.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TeacherDTO teacherDTO;
		ITeacherDAO teacherDAO = new TeacherDAOImpl();
		ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);

		response.setContentType("text/html");

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Integer id = Integer.parseInt(request.getParameter("id"));

		try {
			teacherDTO = new TeacherDTO(id, firstName, lastName);
			teacherServ.insertTeacher(teacherDTO);
			request.setAttribute("insertedTeacher", teacherDTO);
			request.getRequestDispatcher("/jsps/teacherinserted.jsp").forward(request, response);

		} catch (IllegalArgumentException e) {
			// Handle validation errors (e.g., firstName or lastName is null or too long)
			response.getWriter().write("<h1 style=\"color:red\">" + e.getMessage() + "</h1>");
			request.getRequestDispatcher("/jsps/teachermenu.jsp").include(request, response);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		} catch (TeacherIdAlreadyExistsException e2) {
			response.getWriter().write("<h1 style=\"color:red\">" + e2.getMessage() + "</h1>");
			request.getRequestDispatcher("/jsps/teachermenu.jsp").include(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
