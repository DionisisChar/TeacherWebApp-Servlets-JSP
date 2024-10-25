package gr.aueb.elearn.dionChar.teacherapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gr.aueb.elearn.dionChar.teacherapp.model.Teacher;

class TeacherDAOImplTest {

	private TeacherDAOImpl teacherDAO;
	private Teacher testTeacher;

	@BeforeEach
	void setUp() throws ClassNotFoundException, SQLException {
		teacherDAO = new TeacherDAOImpl();
		testTeacher = new Teacher(100, "Dion", "Char");
		teacherDAO.insert(testTeacher);
	}

	@AfterEach
	void tearDown() throws ClassNotFoundException, SQLException {
		teacherDAO.delete(testTeacher);
	}

	@Test
	void testInsertTeacher() throws ClassNotFoundException, SQLException {

		Teacher teacher = new Teacher(101, "James", "Gosling");
		teacherDAO.insert(teacher);

		Teacher fetchedTeacher = teacherDAO.getTeacherById(101);
		assertNotNull(fetchedTeacher, "Teacher should not be Null since it was inserted");
		assertEquals("James", fetchedTeacher.getFirstName());
		assertEquals("Gosling", fetchedTeacher.getLastName());

		teacherDAO.delete(fetchedTeacher); // cleanUp
	}

	@Test
	void testDeleteTeacher() throws ClassNotFoundException, SQLException {

		Teacher teacherToDelete = new Teacher(102, "James", "Gosling");
		teacherDAO.insert(teacherToDelete);

		teacherDAO.delete(teacherToDelete);

		Teacher deletedTeacher = teacherDAO.getTeacherById(101);
		assertNull(deletedTeacher, "Teacher should be NUll since it was deleted");

	}

	@Test
	void testUpdateTeacher() throws ClassNotFoundException, SQLException {

		Teacher newTeacher = new Teacher();
		newTeacher.setFirstName("James");
		newTeacher.setLastName("Gosling");

		teacherDAO.update(testTeacher, newTeacher);

		Teacher updatedTeacher = teacherDAO.getTeacherById(100);

		assertNotNull(updatedTeacher);
		assertEquals("James", updatedTeacher.getFirstName());
		assertEquals("Gosling", updatedTeacher.getLastName());
	}

	@Test
	void testGetTeacherById() throws ClassNotFoundException, SQLException {

		Teacher fetchedTeacher = teacherDAO.getTeacherById(100);

		assertNotNull(fetchedTeacher);
		assertEquals(100, fetchedTeacher.getId());
		assertEquals("Dion", fetchedTeacher.getFirstName());
		assertEquals("Char", fetchedTeacher.getLastName());

	}

	@Test
	void testGetTeacherBySurName() throws ClassNotFoundException, SQLException {
		Teacher teacher1 = new Teacher(103, "George", "Smith");
		Teacher teacher2 = new Teacher(104, "John", "Smith");
		teacherDAO.insert(teacher1);
		teacherDAO.insert(teacher2);

		List<Teacher> teachers = teacherDAO.getTeachersBySurname("Smith");

		assertNotNull(teachers, "Retrieved list should not be null since teachers "
				+ "with last name Smith are inserted");
		assertEquals(2,teachers.size()); //Two teachers with last name Smith
		
		teacherDAO.delete(teacher1);
		teacherDAO.delete(teacher2);
		
	}
		

}
