package com.example.spring.springexample.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class T1Dao {

	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;

	private T1Dao() {
		connection = ConnectionDB.getConnection();
	}

	private static class SingletonHelper {
		private static T1Dao INSTANCE = new T1Dao();
	}

	private static T1Dao getDao = SingletonHelper.INSTANCE;

	public void createTable() {
		String command = "create table if not exists T1(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TXT, AGE INTEGER);";
		try {
			statement = connection.prepareStatement(command);
			statement.execute();
		} catch (SQLException e) {
			System.err.println("cannot create table");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				System.err.println("cannot close statement");
			}
		}
	}

	public void insertion() {
		String command = "insert into T1(name, age) values('ziemo', 32);";
		try {
			statement = connection.prepareStatement(command);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<String> getRecords() {
		List<String> list = new ArrayList<>();
		String query = "select * from T1 where id is 1;";
		try {
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			int columnCount = resultSet.getMetaData().getColumnCount();
			while (resultSet.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String string = resultSet.getString(i);
					list.add(string);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}


	public static void main(String[] args) {
		T1Dao dao = T1Dao.getDao;
		dao.createTable();
		dao.insertion();
		dao.getRecords()
				.forEach(System.out::println);
	}
}
