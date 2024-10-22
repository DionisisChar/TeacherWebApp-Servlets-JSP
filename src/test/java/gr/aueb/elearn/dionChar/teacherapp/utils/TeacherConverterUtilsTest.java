package gr.aueb.elearn.dionChar.teacherapp.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gr.aueb.elearn.dionChar.teacherapp.dto.TeacherDTO;
import gr.aueb.elearn.dionChar.teacherapp.model.Teacher;

class TeacherConverterUtilsTest {

	@Test
	void testConvertToModel_NullDTO_ShouldReturnNullTeacherModel() {
		Teacher teacher = TeacherConverterUtils.convertToModel(null);

		assertNull(teacher);

	}

	@Test
	void testConvertToModel_ValidDTO_ShouldReturnATeacherModel() {
		TeacherDTO teacherDTO = new TeacherDTO(1, "Dion", "Char");
		Teacher teacher = TeacherConverterUtils.convertToModel(teacherDTO);

		assertNotNull(teacher);
		assertEquals(1, teacher.getId());
		assertEquals("Dion", teacher.getFirstName());
		assertEquals("Char", teacher.getLastName());
	}

	@Test
	void testConvertToDTO_NullModel_ShouldReturnNullTeacherDTO() {
		TeacherDTO teacherDTO = TeacherConverterUtils.convertToDTO(null);
		
		assertNull(teacherDTO);
	}
	
	@Test
	void testConvertToDTO_ValidModel_ShouldReturnATeacherDTO() {
		Teacher teacher = new Teacher(2,"Dion","Char");
		TeacherDTO teacherDTO = TeacherConverterUtils.convertToDTO(teacher);
		
		assertNotNull(teacherDTO);
		assertEquals(2,teacherDTO.getId());
		assertEquals("Dion",teacherDTO.getFirstName());
		assertEquals("Char",teacherDTO.getLastName());
	}

}
