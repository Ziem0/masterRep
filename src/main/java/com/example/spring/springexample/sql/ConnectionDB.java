package com.example.spring.springexample.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	private static Connection connection = null;
	private static final String DB_URL = "jdbc:sqlite:src/main/resources/db/test.db";

	private ConnectionDB() {
	}

	private static class SingletonHelper {
		private static Connection connection;

		static {
			try {
				connection = createConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		private static Connection createConnection() throws SQLException {
			connection = DriverManager.getConnection(DB_URL);
			return connection;
		}
	}

	public static Connection getConnection() {
		return SingletonHelper.connection;
	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("error while closing DB");
		}
	}

}
