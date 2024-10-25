package gr.aueb.elearn.dionChar.teacherapp.dao.dbutil;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DBUtilTest {

	private static Connection connection;

	@BeforeEach
	void setUp() throws ClassNotFoundException, SQLException {
		connection = DBUtil.openConnection();
	}

	@AfterEach
	void tearDown() throws SQLException {
		DBUtil.closeConnection();
		connection = null;
	}

	@Test
	void test_OpenConnection() {
		assertNotNull(connection, "Connection should be open");
		assertDoesNotThrow(() -> connection.isValid(2));
	}

	@Test
	void test_CloseConnection() throws SQLException {
		assertNotNull(connection, "Connection should be open");
		DBUtil.closeConnection();
		assertTrue(connection.isClosed(), "Connection should be closed");
	}

	@Test
	void testCloseResultSet_Null() {
		assertDoesNotThrow(() -> DBUtil.closeRS(null), "Closing Null result set should not throw any exception");
	}

	@Test
	void testClosePreparedStatement_Null() {
		assertDoesNotThrow(() -> DBUtil.closeStmt(null),
				"Clossing Null prepared statement should not throw any exception");
	}

	@Test
	void testCloseResultSet_WithOpenResultSet() throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("SELECT 1");
		ResultSet rs = stmt.executeQuery();

		assertNotNull(rs);
		DBUtil.closeRS(rs);
		assertTrue(rs.isClosed(), "Result set should be closed");
		DBUtil.closeStmt(stmt); // Clean up the prepared statement
	}

	@Test
	void testClosePreparedStatement_WithOpenStatement() throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("SELECT 1");
		
		assertNotNull(stmt);
		assertFalse(stmt.isClosed());
		DBUtil.closeStmt(stmt);
		assertTrue(stmt.isClosed(), "Prepared statement should be closed");
	}

}
