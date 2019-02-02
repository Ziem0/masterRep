package com.example.spring.springexample.algorithms.findWay;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoadData {

	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private List<String> results;
	private Graph graph;

	private LoadData() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/db/test.db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.graph = new Graph();
	}

	private static class SingletonHelper {
		private static LoadData INSTANCE = new LoadData();
	}

	public static LoadData getLoadData() {
		return SingletonHelper.INSTANCE;
	}

	public Graph getGraph() {
		return graph;
	}

	private List<String> handleStatement(String command, String[] userNeeds) throws SQLException {
		results = new ArrayList<>();
		statement = connection.prepareStatement(command);
		resultSet = statement.executeQuery();
		while (resultSet.next()) {
			String start = resultSet.getString(1);
			String destination = resultSet.getString(2);
			Integer distance = resultSet.getInt(3);

			Node node1 = new Node(start);
			Node node2 = new Node(destination);

			Node s = graph.addAdj(node1);
			Node d = graph.addAdj(node2);

			graph.addAdj(s).addAdjacency(d, distance);
			graph.addAdj(d).addAdjacency(s, distance);
		}

		resultSet.close();
		statement.close();

		return results;
	}

	public void getAllNodes() throws SQLException {
		handleStatement("select * from plan", null);
	}



}
