package gr.aueb.elearn.dionChar.teacherapp.dto;

import gr.aueb.elearn.dionChar.teacherapp.utils.ValidationUtils;

/**
 * Data Transfer Object (DTO) for transferring teacher data between layers in
 * the application (typically between the controller layer and the service
 * layer).
 * 
 * The class encapsulates the teacher's ID, first name, and last name and
 * provides validation for these fields to ensure data integrity.
 * 
 * Validation rules: - First name and last name cannot be null. - First name and
 * last name cannot exceed 40 characters in length.
 * 
 * The class throws an {@link IllegalArgumentException} if any validation fails.
 */

public class TeacherDTO {

	private int id;
	private String firstName;
	private String lastName;

	public TeacherDTO() {
	}

	/**
	 * Constructor that accepts an id, first name, and last name for creating a new
	 * TeacherDTO instance. The constructor performs validation to ensure that the
	 * first name and last name are not null and do not exceed 40 characters.
	 * 
	 * @param id        The unique identifier for the teacher.
	 * @param firstName The first name of the teacher (must not be null or exceed 40
	 *                  characters).
	 * @param lastName  The last name of the teacher (must not be null or exceed 40
	 *                  characters).
	 * @throws IllegalArgumentException if the first name or last name are null or
	 *                                  exceed 40 characters.
	 */
	public TeacherDTO(int id, String firstName, String lastName) {
		super();
		this.id = id;
		setFirstName(firstName);
		setLastName(lastName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	/**
	 * @throws IllegalArgumentException if the first name is null or exceeds 40
	 *                                  characters.
	 */
	public void setFirstName(String firstName) {
		ValidationUtils.checkNull(firstName, "First Name");
		ValidationUtils.checkSize(firstName, 40, "First Name");
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	/**
	 * @throws IllegalArgumentException if the last name is null or exceeds 40
	 *                                  characters.
	 */
	public void setLastName(String lastName) {
		ValidationUtils.checkNull(lastName, "Last Name");
		ValidationUtils.checkSize(lastName, 40, "Last Name");
		this.lastName = lastName;
	}
}
