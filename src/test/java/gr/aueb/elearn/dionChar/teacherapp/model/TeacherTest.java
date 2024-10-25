package gr.aueb.elearn.dionChar.teacherapp.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TeacherTest {

	@Test
	void testToString() {
		Teacher teacher = new Teacher(1,"Dion","Char");
		assertEquals("1\tDion\tChar", teacher.toString());
	}

}
