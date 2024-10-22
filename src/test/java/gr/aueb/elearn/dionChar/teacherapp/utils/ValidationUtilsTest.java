package gr.aueb.elearn.dionChar.teacherapp.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidationUtilsTest {

	@Test
	void checkNull_WithNonNullVallue_ShouldNotThrowException() {
		assertDoesNotThrow(() -> {
			ValidationUtils.checkNull("NonNll", "TestField");
		});
	}

	@Test
	void checkNull_WithNullVallue_ShouldThrowException() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			ValidationUtils.checkNull(null, "TestField");
		});

		assertEquals("TestField is required", thrown.getMessage());
	}

	@Test
	void checkSize_WithValidSizeInput_ShouldNotThrowException() {
		assertDoesNotThrow(() -> {
			ValidationUtils.checkSize("Valid Input", 20, "TestField");
		});
	}

	@Test
	void checkSize_WithExceedingSizeInput_ShouldThrowAnException() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			ValidationUtils.checkSize("TooLongValue", 5, "TestField");
		});
		
		assertEquals("TestField cannot exceed 5 characters", thrown.getMessage());
	}

}
