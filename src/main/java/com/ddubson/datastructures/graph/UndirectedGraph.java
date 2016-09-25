package com.ddubson.datastructures.graph;


import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Author: ddubson
 */
public class UndirectedGraph implements Graph {
    private Map<Node, Set<Node>> adjList;
    private Map<Integer, Node> nodesList;

    public UndirectedGraph() {
        adjList = new HashMap<>();
        nodesList = new HashMap<>();
    }

    public List<Node> getAllNodes() {
        return nodesList.values().stream().collect(toList());
    }

    public Set<Node> getAllConnectedNodes(int rootNodeName) throws NodeDoesNotExist {
        return adjList.get(getNodeByName(rootNodeName));
    }

    public boolean nodeExists(int nodeId) {
        return nodesList.containsKey(nodeId);
    }

    public boolean edgeExists(int node1, int node2) throws NodeDoesNotExist {
        assertNodeExists(node1);
        assertNodeExists(node2);
        Node n1 = getNodeByName(node1);
        Node n2 = getNodeByName(node2);
        return (adjList.get(n1).contains(n2) && adjList.get(n2).contains(n1));
    }

    public void createEdge(int node1, int node2) {
        Node n1 = getNodeByName(node1);
        Node n2 = getNodeByName(node2);

        if (!adjList.containsKey(n1)) {
            adjList.put(n1, new HashSet<>());
        }

        if (!adjList.containsKey(n2)) {
            adjList.put(n2, new HashSet<>());
        }

        adjList.get(n1).add(n2);
        adjList.get(n2).add(n1);
    }

    public Node getNodeByName(int nodeName) throws NodeDoesNotExist {
        assertNodeExists(nodeName);
        return nodesList.get(nodeName);
    }

    private void assertNodeExists(int nodeName) throws NodeDoesNotExist {
        if (!nodeExists(nodeName)) throw new NodeDoesNotExist();
    }

    public void add(Node node) throws NodeExists {
        if (nodeExists(node.name)) throw new NodeExists();

        nodesList.put(node.name, node);
    }

    public class NodeExists extends RuntimeException {
    }

    public class NodeDoesNotExist extends RuntimeException {
    }
}
