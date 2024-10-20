package gr.aueb.elearn.dionChar.teacherapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import gr.aueb.elearn.dionChar.teacherapp.model.Teacher;
import static gr.aueb.elearn.dionChar.teacherapp.dao.dbutil.DBUtil.openConnection;
import static gr.aueb.elearn.dionChar.teacherapp.dao.dbutil.DBUtil.closeConnection;
import static gr.aueb.elearn.dionChar.teacherapp.dao.dbutil.DBUtil.closeRS;
import static gr.aueb.elearn.dionChar.teacherapp.dao.dbutil.DBUtil.closeStmt;

/**
 * * Implementation of the ITeacherDAO interface for managing Teacher data in
 * the database. This class provides methods to insert, update, delete, and
 * retrieve teacher records using JDBC.
 * 
 * The methods in this class directly interact with the database using SQL
 * queries and handle SQL exceptions appropriately.
 */


//TODOs for TeacherDAOImpl class
/*
* TODO: Update SQL queries to use PreparedStatement with parameters. (SQL Injection Prevention)
* TODO: Implement a proper exception handling instead of printing stack traces.
* TODO: Instead of returning null when no teachers are found, better return an empty list?
*/
public class TeacherDAOImpl implements ITeacherDAO {

	@Override
	public void insert(Teacher teacher) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO TEACHERS VALUES ('" + teacher.getId() + "', '" + teacher.getLastName() + "', '"
				+ teacher.getFirstName() + "')";

		PreparedStatement pst = openConnection().prepareStatement(sql);
		int n = pst.executeUpdate(sql);

		System.out.println(n + " Record(s) inserted.");

		closeStmt(pst);
		closeConnection();
	}

	
	@Override
	public void delete(Teacher teacher) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM TEACHERS WHERE TEACHER_ID = " + teacher.getId();
		// int dialogButton;

		PreparedStatement pst = openConnection().prepareStatement(sql);

		int numberOfRowsAffected = pst.executeUpdate();

		if (numberOfRowsAffected > 0) {
			System.out.println(numberOfRowsAffected + " rows deleted successfully.");
		} else {
			System.out.println("No rows were deleted. Teacher ID may not exist.");
		}

		/*
		 * dialogButton = JOptionPane.showConfirmDialog(null, "����� ��������;",
		 * "Warning", JOptionPane.YES_NO_OPTION);
		 * 
		 * if (dialogButton == JOptionPane.YES_OPTION) { int numberOfRowsAffected =
		 * pst.executeUpdate(); JOptionPane.showMessageDialog(null, numberOfRowsAffected
		 * + " rows deleted successfully", "DELETE", JOptionPane.INFORMATION_MESSAGE); }
		 * else { return; }
		 */

		closeStmt(pst);
		closeConnection();
	}
	

	@Override
	public void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException, ClassNotFoundException {

		String sql = "UPDATE TEACHERS SET S_NAME = '" + newTeacher.getLastName() + "', " + "F_NAME = '"
				+ newTeacher.getFirstName() + "' WHERE TEACHER_ID = " + oldTeacher.getId();
		System.out.println(sql);

		PreparedStatement pst = null;

		try {
			pst = openConnection().prepareStatement(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int numberOfRowsAffected = pst.executeUpdate();

		if (numberOfRowsAffected > 0) {
			System.out.println(numberOfRowsAffected + " rows updated successfully.");
		} else {
			System.out.println("No rows were updated. Teacher ID may not exist.");
		}

		// JOptionPane.showMessageDialog(null, numberOfRowsAffected + " rows affected",
		// "UPDATE",
		// JOptionPane.PLAIN_MESSAGE);

		closeStmt(pst);
		closeConnection();
	}

	
	@Override
	public List<Teacher> getTeachersBySurname(String surname) throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT TEACHER_ID, S_NAME, F_Name FROM TEACHERS WHERE S_NAME LIKE '" + surname + "%'";
		// String sql = "SELECT TEACHER_ID, S_NAME, F_Name FROM TEACHERS WHERE S_NAME
		// LIKE ?";

		PreparedStatement pst = openConnection().prepareStatement(sql);

		ResultSet rs = pst.executeQuery(sql);

		List<Teacher> teachers = new ArrayList<>();

		while (rs.next()) {
			Teacher teacher = new Teacher();

			teacher.setId(rs.getInt("TEACHER_ID"));
			teacher.setLastName(rs.getString("S_NAME"));
			teacher.setFirstName(rs.getString("F_NAME"));
			teachers.add(teacher);
		}

		closeRS(rs);
		closeStmt(pst);
		closeConnection();

		return (!teachers.isEmpty()) ? teachers : null;
	}

	
	@Override
	public Teacher getTeacherById(int id) throws SQLException, ClassNotFoundException {
		boolean teacherFound = false;

		String sql = "SELECT * FROM TEACHERS WHERE TEACHER_ID = " + id;
		PreparedStatement pst = openConnection().prepareStatement(sql);
		ResultSet rs = pst.executeQuery(sql);

		Teacher teacher = new Teacher();

		if (rs.next()) {

			teacher.setId(rs.getInt("TEACHER_ID"));
			teacher.setLastName(rs.getString("S_NAME"));
			teacher.setFirstName(rs.getString("F_NAME"));
			teacherFound = true;
		}

		closeRS(rs);
		closeStmt(pst);
		closeConnection();

		return (teacherFound) ? teacher : null;
	}
}
