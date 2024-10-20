package gr.aueb.elearn.dionChar.teacherapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.elearn.dionChar.teacherapp.service.ITeacherService;
import gr.aueb.elearn.dionChar.teacherapp.service.TeacherServiceImpl;
import gr.aueb.elearn.dionChar.teacherapp.dao.ITeacherDAO;
import gr.aueb.elearn.dionChar.teacherapp.dao.TeacherDAOImpl;
import gr.aueb.elearn.dionChar.teacherapp.dto.TeacherDTO;

/**
 * Servlet for searching teachers by surname.
 * <p>
 * This servlet handles GET requests to search for teachers based on their last name,
 * retrieves the relevant teacher data from the service layer, and forwards the results
 * to a JSP page for display.
 * </p>
 */

@WebServlet("/TeacherSearchController")
public class TeacherSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ITeacherDAO teacherDAO = new TeacherDAOImpl();
		ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);
		List<TeacherDTO> teachers = new ArrayList<>();
		
		response.setContentType("text/html");
		String lastName = request.getParameter("searchInput");
		
		try {
			teachers = teacherServ.getTeachersBySurname(lastName);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if (teachers != null) {
			request.setAttribute("teachers", teachers);
			request.getRequestDispatcher("/jsps/teachers.jsp").forward(request, response);
			
		} else {
			response.getWriter().write("<h1 style=\"color:red\">Teacher does not exist</h1>");
			request.getRequestDispatcher("/jsps/teachersmenu.jsp").include(request, response);
		}
	}
}
