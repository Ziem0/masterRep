package com.example.spring.springexample.algorithms.findWay;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Graph {

	private List<Node> nodes;

	public Graph() {
		this.nodes = new LinkedList<>();
	}

	public Node addAdj(Node node) {
		Node searchedNode = null;
		for (Node node1 : nodes) {
			if (node1.getName().equals(node.getName())) {
				searchedNode = node1;
			}
		}

		if (searchedNode == null) {
			nodes.add(node);
			searchedNode = node;
		}
		return searchedNode;
	}


}
