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

import com.google.gson.Gson;
import gr.aueb.elearn.dionChar.teacherapp.service.ITeacherService;
import gr.aueb.elearn.dionChar.teacherapp.service.TeacherServiceImpl;
import gr.aueb.elearn.dionChar.teacherapp.dao.ITeacherDAO;
import gr.aueb.elearn.dionChar.teacherapp.dao.TeacherDAOImpl;
import gr.aueb.elearn.dionChar.teacherapp.dto.TeacherDTO;
/**
 * Servlet implementation class TeacherSearchController
 */
@WebServlet("/TeacherSearchJSONController")
public class TeacherSearchJSONController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ITeacherDAO teacherDAO = new TeacherDAOImpl();
		ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);
		List<TeacherDTO> teachers = new ArrayList<>();
		
		Gson gson = new Gson();
		String gsonResponse;
		
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		String lastName = request.getParameter("searchInput");
		
		try {
			teachers = teacherServ.getTeachersBySurname(lastName);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if (teachers != null) {
			gsonResponse = gson.toJson(teachers);
			response.getWriter().write(gsonResponse);
			System.out.println(gsonResponse);
		} else {
			response.getWriter().write("{}");
		}
	}
}
