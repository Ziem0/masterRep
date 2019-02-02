package com.example.spring.springexample.algorithms.findWay;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Node {

	private String name;
	private Integer distance;
	private Map<Node, Integer> adjacents;
	private List<Node> shortestPath;  // shortest path to this node from selected base node

	public Node(String name) {
		this.name = name;
		this.distance = Integer.MAX_VALUE;
		this.adjacents = new HashMap<>();
		this.shortestPath = new LinkedList<>();
	}

	public void addAdjacency(Node newNode, int distance) {
		boolean isNewNodePresent = true;
		for (Node node : adjacents.keySet()) {
			if (node.name.equals(newNode.name)) {
				isNewNodePresent = false;
			}
		}
		if (isNewNodePresent) {
			adjacents.put(newNode, distance);
		}
	}

}
