package gr.aueb.elearn.dionChar.teacherapp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import gr.aueb.elearn.dionChar.teacherapp.dao.ITeacherDAO;
import gr.aueb.elearn.dionChar.teacherapp.dto.TeacherDTO;
import gr.aueb.elearn.dionChar.teacherapp.model.Teacher;
import gr.aueb.elearn.dionChar.teacherapp.service.exception.TeacherIdAlreadyExistsException;
import gr.aueb.elearn.dionChar.teacherapp.service.exception.TeacherNotFoundException;
import gr.aueb.elearn.dionChar.teacherapp.utils.TeacherConverterUtils;

/**
 * Implementation of the ITeacherService interface for managing Teacher entities.
 * This class provides methods for inserting, deleting, updating, and retrieving 
 * Teacher records, implementing the ITeacherDAO for database interactions.
 */

public class TeacherServiceImpl implements ITeacherService {

	private final ITeacherDAO teacherDAO;

	public TeacherServiceImpl(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public void insertTeacher(TeacherDTO teacherDTO)
			throws TeacherIdAlreadyExistsException, SQLException, ClassNotFoundException {

	    // Converts DTO to model and checks for existence before insertion
		Teacher newTeacher = TeacherConverterUtils.convertToModel(teacherDTO);

		if ((teacherDAO.getTeacherById(newTeacher.getId())) == null)
			teacherDAO.insert(newTeacher);
		else {
			throw new TeacherIdAlreadyExistsException(newTeacher);
		}
	}
	

	@Override
	public void deleteTeacher(TeacherDTO teacherDTO)
			throws TeacherNotFoundException, SQLException, ClassNotFoundException {

		int teacherId = teacherDTO.getId();
		Teacher teacherToDelete = teacherDAO.getTeacherById(teacherId);
		if (teacherToDelete == null) {
			throw new TeacherNotFoundException(teacherToDelete);
		}
		teacherDAO.delete(teacherToDelete);
	}
	

	@Override
	public void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO)
			throws TeacherNotFoundException, SQLException, ClassNotFoundException {

		Teacher teacherToUpdate = new Teacher();
		teacherToUpdate.setId(oldTeacherDTO.getId());

	    // Converts DTO to model and checks for existence before insertion
		Teacher updatedTeacher = TeacherConverterUtils.convertToModel(newTeacherDTO);

		if ((teacherDAO.getTeacherById(teacherToUpdate.getId())) == null)
			throw new TeacherNotFoundException(teacherToUpdate);

		teacherDAO.update(teacherToUpdate, updatedTeacher);

	}
	

	@Override
	public List<TeacherDTO> getTeachersBySurname(String surname) throws SQLException, ClassNotFoundException {

		// Retrieves teachers based on surname and converts them to DTOs
		List<Teacher> teachers = teacherDAO.getTeachersBySurname(surname);

		return teachers.stream().map(TeacherConverterUtils::convertToDTO).collect(Collectors.toList());
	}
	

	@Override
	public TeacherDTO getTeacherById(int id) throws SQLException, ClassNotFoundException, TeacherNotFoundException {
		
		// Retrieves a teacher by ID and convert it to DTO.
		Teacher teacher = teacherDAO.getTeacherById(id);
		if (teacher == null) {
			throw new TeacherNotFoundException(teacher);
		}

		return TeacherConverterUtils.convertToDTO(teacher);
	}

}
