package gr.aueb.elearn.dionChar.teacherapp.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TeacherDTOTest {

	@Test
	void test_No_Args_Constructor(){
		TeacherDTO teacher = new TeacherDTO();
		assertEquals(0,teacher.getId());
		assertEquals(null,teacher.getFirstName());
		assertEquals(null,teacher.getLastName());
	}
	
	@Test
	void testingConstructor_And_Getters_WithValidInput() {
		TeacherDTO teacher = new TeacherDTO(1, "Dion", "Char");

		assertEquals(1, teacher.getId());
		assertEquals("Dion", teacher.getFirstName());
		assertEquals("Char", teacher.getLastName());

	}

	@Test
	void testConstructor_With_Null_FirstName() {

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			new TeacherDTO(1, null, "Char");
		});
		assertEquals("First Name is required", thrown.getMessage());
	}

	@Test
	void testConstructor_With_Exceeding_Length_FirstName() {

		String longFirstName = "This name is way too long for the Validation check";
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			new TeacherDTO(1, longFirstName, "Char");
		});
		
		assertEquals("First Name cannot exceed 40 characters", thrown.getMessage());
	}
	
	@Test
	void testConstructor_With_Null_LastName() {

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			new TeacherDTO(1, "Dion", null);
		});
		assertEquals("Last Name is required", thrown.getMessage());
	}
	
	@Test
	void testConstructor_With_Exceeding_Length_LastName() {

		String longLastName = "This lastname is way too long for the Validation check";
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			new TeacherDTO(1,"Dion" , longLastName);
		});
		
		assertEquals("Last Name cannot exceed 40 characters", thrown.getMessage());
	}
	
	@Test
	void test_ID_Setter() {
		TeacherDTO teacher = new TeacherDTO(1,"Dion","Char");
		teacher.setId(2);
		assertEquals(2,teacher.getId());
	}
}
