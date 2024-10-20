package gr.aueb.elearn.dionChar.teacherapp.service.exception;

import gr.aueb.elearn.dionChar.teacherapp.model.Teacher;

/**
 * Exception thrown when a teacher is not found.
 * <p>
 * This exception is used to indicate that a specified teacher could not be found
 * in the data source.
 * </p>
 * 
 */

//TODO: Allow a custom  message to the Exception. 


public class TeacherNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
     * Constructs a {@link TeacherNotFoundException} with a specific teacher.
     *
     * @param teacher the Teacher that was not found.
     */
	
	public TeacherNotFoundException(Teacher teacher) {
		super("Teacher with id = " + teacher.getId() + " does no exist");
	}

}
