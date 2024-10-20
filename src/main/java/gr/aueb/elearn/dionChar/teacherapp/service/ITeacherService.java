package gr.aueb.elearn.dionChar.teacherapp.service;
import java.sql.SQLException;
import java.util.List;

import gr.aueb.elearn.dionChar.teacherapp.dto.TeacherDTO;
import gr.aueb.elearn.dionChar.teacherapp.model.Teacher;
import gr.aueb.elearn.dionChar.teacherapp.service.exception.TeacherIdAlreadyExistsException;
import gr.aueb.elearn.dionChar.teacherapp.service.exception.TeacherNotFoundException;

public interface ITeacherService {	
	
	/**
	 * Inserts a {@link Teacher} based on the data carried by the
	 * {@link TeacherDTO}.
	 * 
	 * @param teacherDTO 
	 * 			TeacherDTO object that contains the data.
	 * @throws TeacherIdAlreadyExistsException
	 * 			if any Teacher identified by their id 
	 * 			needed to be inserted has been already
	 * 			inserted. 
	 * @throws SQLException
	 * 			if any error occurs between the driver
	 * 			and the server.
	 * @throws ClassNotFoundException 
	 */
	void insertTeacher(TeacherDTO teacherDTO) 
			throws TeacherIdAlreadyExistsException, SQLException, ClassNotFoundException;
	
	/**
	 * Deletes a {@link Teacher} based on the data carried by the
	 * {@link TeacherDTO}.
	 * 
	 * @param teacherDTO 
	 * 			TeacherDTO object that contains the data.
	 * @throws TeacherIdAlreadyExistsException
	 * 			if any Teacher identified by their id 
	 * 			needed to be inserted has been already
	 * 			inserted. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 * @throws ClassNotFoundException 
	 */
	
	void deleteTeacher(TeacherDTO teacherDTO)
			throws TeacherNotFoundException, SQLException, ClassNotFoundException;
	
	
	/**
	 * Updates a {@link Teacher} based on the data carried by the
	 * {@link TeacherDTO}.
	 * 
	 * @param oldTeacherDTO
	 * 			TeacherDTO object that contains the data -mainly the id-
	 * 			of the {@link Teacher} that will be updated.  
	 * @param newTeacherDTO
	 * 			TeacherDTO object that contains the data of the 
	 * 			new {@link Teacher}.
	 * @throws TeacherNotFoundException
	 * 			if any Teacher identified by their id 
	 * 			was not found. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 * @throws ClassNotFoundException 
	 */
	void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO) 
			throws TeacherNotFoundException, SQLException, ClassNotFoundException;
	
	
	
	/**
	 * Searches and gets back to the caller a list
	 * of the {@link TeacherDTO} objects identified by
	 * by their surname or surname's initial letters.
	 * 
	 * @param   surname
	 * 			a String object that contains the
	 * 			surname or the letters that the 
	 * 			surname starts with, of the {@link TeacherDTO}
	 * 			objects we are looking for. 
	 * @return
	 * 			a List that contains the results of
	 * 			the search, that is a List of {@link TeacherDTO}
	 * 			objects. 
	 * @throws  SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 * @throws  ClassNotFoundException 
	 */
	List<TeacherDTO> getTeachersBySurname(String surname) 
			throws SQLException, ClassNotFoundException;
	
	/**
	 * Searches and gets back to the caller a single
	 * {@link TeacherDTO} object identified by
	 * its id.
	 * 
	 * @param id
	 * 			an integer object that contains the
	 * 			id number of the {@link TeacherDTO}
	 * 			object we are looking for. 
	 * @return
	 * 			results of the search, that is a 
	 * 			{@link TeacherDTO} object. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 * @throws ClassNotFoundException 
	 * @throws TeacherNotFoundException
	 */
	TeacherDTO getTeacherById(int id)throws SQLException, ClassNotFoundException, TeacherNotFoundException;
}
