package gr.aueb.elearn.dionChar.teacherapp.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Utility class for managing database connections and resources such as result
 * sets and prepared statements. Provides methods for opening and closing
 * database connections.
 * 
 * This class is intended to be used in DAO classes to perform database
 * operations.
 * 
 * @author D. Charalampopoulos
 */

public class DBUtil {

	// TODO: Change the static Connection variable to a connection pool
	// implementation
	// and make changes to related methods accordingly in the future.
	private static Connection conn;

	/*
	 * No instances will be available
	 */
	private DBUtil() {
	}

	public static Connection openConnection() throws SQLException, ClassNotFoundException {

		String url = "jdbc:mysql://localhost:3306/teachers-db?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "root";
		String password = "1990sakis@!@!";

		Class.forName("com.mysql.cj.jdbc.Driver");

		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		conn = DriverManager.getConnection(url, username, password);

		return conn;
	}

	public static void closeConnection() throws SQLException {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeRS(ResultSet rs) throws SQLException {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeStmt(PreparedStatement stmt) throws SQLException {
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
