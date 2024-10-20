package gr.aueb.elearn.dionChar.teacherapp.service.exception;

import gr.aueb.elearn.dionChar.teacherapp.model.Teacher;

/**
 * Exception thrown when attempting to create a teacher with an ID that already
 * exists.
 * <p>
 * This exception is used to indicate that a teacher with the given ID already
 * exists in the data source, which prevents the creation operation.
 * </p>
 * 
 */

//TODO: Allow a custom  message to the Exception. 

public class TeacherIdAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a {@link TeacherIdAlreadyExistsException} with the specified
	 * teacher.
	 * 
	 * @param teacher The Teacher that could not be created due to duplicate ID.
	 */
	public TeacherIdAlreadyExistsException(Teacher teacher) {
		super("Teacher with id = " + teacher.getId() + " already exist");
	}

}