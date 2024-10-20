package gr.aueb.elearn.dionChar.teacherapp.utils;

/**
 * Utility class for validating input data. This class provides static methods
 * to check if an object is null or if a string exceeds a maximum length.
 * 
 * The methods in this class throw an {@link IllegalArgumentException} if
 * validation fails.
 */

public class ValidationUtils {

	/**
	 * Validates that the provided value is not null. If the value is null, an
	 * {@link IllegalArgumentException} is thrown with a message that specifies the
	 * field name.
	 * 
	 * @param value     The object to validate.
	 * @param fieldName The name of the field being validated (used in the exception
	 *                  message).
	 * @throws IllegalArgumentException if the value is null.
	 */
	public static void checkNull(Object value, String fieldName) {
		if (value == null) {
			throw new IllegalArgumentException(fieldName + " is required");
		}
	}

	/**
	 * Validates that the provided string does not exceed the specified maximum
	 * size. If the string length exceeds the maximum size, an
	 * {@link IllegalArgumentException} is thrown with a message that specifies the
	 * field name and maximum size.
	 * 
	 * @param value     The string to validate.
	 * @param maxSize   The maximum allowed size for the string.
	 * @param fieldName The name of the field being validated (used in the exception
	 *                  message).
	 * @throws IllegalArgumentException if the string exceeds the specified size.
	 */
	public static void checkSize(String value, int maxSize, String fieldName) {
		if (value.length() > maxSize) {
			throw new IllegalArgumentException(fieldName + " cannot exceed  " + maxSize + " characters");
		}
	}

}
