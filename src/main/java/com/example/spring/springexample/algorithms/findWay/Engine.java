package com.example.spring.springexample.algorithms.findWay;

import java.sql.SQLException;
import java.util.*;

public class Engine {

	private final LoadData loadData;
	private final Graph graph;

	private Set<Node> visited;
	private Set<Node> unvisited;

	private String start;
	private String destination;
	private Node source;
	private Node end;

	public Engine() throws SQLException {
		this.visited = new HashSet<>();
		this.unvisited = new HashSet<>();
		this.loadData = LoadData.getLoadData();
		loadData.getAllNodes();
		this.graph = loadData.getGraph();
		this.start = "Warsaw";
		this.destination = "Athens";
		this.source = graph.addAdj(new Node(start));
		this.end = graph.addAdj(new Node(destination));
		calculateShortestPath(source);
	}

	public void calculateShortestPath(Node source) {
		source.setDistance(0);
		this.unvisited.add(source);

		while (unvisited.size() > 0) {
			Node currentNode = getLowestDistanceNode();
			unvisited.remove(currentNode);

			for (Map.Entry<Node, Integer> entry : currentNode.getAdjacents().entrySet()) {
				Node adjacencyNode = entry.getKey();
				Integer weigh = entry.getValue();
				if (!visited.contains(adjacencyNode)) {
					calculateMinimunDistance(currentNode, adjacencyNode, weigh);
					unvisited.add(adjacencyNode);
				}
			}
			visited.add(currentNode);
		}
	}

	private void calculateMinimunDistance(Node currentNode, Node adjacencyNode, Integer weigh) {
		if (currentNode.getDistance() + weigh < adjacencyNode.getDistance()) {
			adjacencyNode.setDistance(weigh + currentNode.getDistance());
			List<Node> tempShortestPath = new LinkedList<>(currentNode.getShortestPath());
			tempShortestPath.add(currentNode);
			adjacencyNode.setShortestPath(tempShortestPath);
		}
	}


	private Node getLowestDistanceNode() {
		Node lowestDistanceNode = null;
		int lowestDistance = Integer.MAX_VALUE;

		for (Node node : unvisited) {
			if (node.getDistance() < lowestDistance) {
				lowestDistanceNode = node;
				lowestDistance = node.getDistance();
			}
		}
		return lowestDistanceNode;
	}


	public static void main(String[] args) throws SQLException {
		Engine engine = new Engine();
		System.out.println(engine.end.getDistance());
		engine.end.getShortestPath().forEach(n -> System.out.println(n.getName()));
		System.out.println(engine.destination);

//		System.out.println(engine.graph.getNodes().get(1).getName());
//		engine.graph.getNodes().get(1).getAdjacents().keySet().forEach(e -> System.out.println(e.getName()));
	}


}
