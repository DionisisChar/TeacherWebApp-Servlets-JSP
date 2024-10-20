package gr.aueb.elearn.dionChar.teacherapp.utils;

import gr.aueb.elearn.dionChar.teacherapp.dto.TeacherDTO;
import gr.aueb.elearn.dionChar.teacherapp.model.Teacher;

/**
 * Utility class for converting between {@link Teacher} model objects and
 * {@link TeacherDTO} data transfer objects.
 * 
 * Provides static methods to convert from DTO to Model and vice versa.
 */

public class TeacherConverterUtils {

	/**
	 * 
	 * @param teacherDTO The {@link TeacherDTO} object to be converted.
	 * @return A {@link Teacher} model object or {@code null} if the input is null.
	 */
	public static Teacher convertToModel(TeacherDTO teacherDTO) {

		if (teacherDTO == null) {
			return null;
		}

		Teacher teacher = new Teacher(teacherDTO.getId(), teacherDTO.getFirstName(), teacherDTO.getLastName());
		return teacher;

	}

	/**
	 * 
	 * @param teacher The {@link Teacher} model object to be converted.
	 * @return A {@link TeacherDTO} dto object or {@code null} if the input is null.
	 */
	public static TeacherDTO convertToDTO(Teacher teacher) {

		if (teacher == null) {
			return null;
		}

		TeacherDTO teacherDTO = new TeacherDTO(teacher.getId(), teacher.getFirstName(), teacher.getLastName());
		return teacherDTO;
	}

}
