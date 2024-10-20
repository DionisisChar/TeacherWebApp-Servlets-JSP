package gr.aueb.elearn.dionChar.teacherapp.dao;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.elearn.dionChar.teacherapp.model.Teacher;

/**
 * Data Access Object (DAO) interface for managing Teacher entities.
 * 
 * This interface defines methods for performing CRUD operations on Teacher
 * objects, including methods to insert, delete, update, and retrieve teachers
 * based on various criteria.
 * 
 * All methods may throw ({@link SQLException} and
 * {@link ClassNotFoundException} if a database access error occurs or if the
 * database driver class is not found.
 */

public interface ITeacherDAO {

	/**
	 * Inserts a new Teacher into the database.
	 * 
	 * @param teacher The Teacher object to be inserted.
	 */
	void insert(Teacher teacher) throws SQLException, ClassNotFoundException;

	
	/**
	 * Deletes a Teacher from the database.
	 * 
	 * @param teacher The Teacher object to be deleted.
	 */
	void delete(Teacher teacher) throws SQLException, ClassNotFoundException;

	
	/**
	 * Updates an existing Teacher in the database.
	 * 
	 * @param oldTeacher The Teacher object to be updated.
	 * @param newTeacher The Teacher object containing updated information.
	 */
	void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException, ClassNotFoundException;

	
	/**
	 * Retrieves a list of Teacher objects matching the given surname.
	 * 
	 * @param surname The surname to search for.
	 * @return A list of {@link Teacher} objects or null if the list is empty.
	 */
	List<Teacher> getTeachersBySurname(String surname) throws SQLException, ClassNotFoundException;

	
	/**
	 * Retrieves a Teacher by its unique ID.
	 * 
	 * @param id The unique identifier of the Teacher.
	 * @return The Teacher object with the specified ID or null if not found.
	 */
	Teacher getTeacherById(int id) throws SQLException, ClassNotFoundException;

}
