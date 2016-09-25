package com.ddubson.datastructures.graph;


import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Author: ddubson
 */
public class UndirectedGraph implements Graph {
    private Map<Node, Map<Node, Set<Edge>>> adjList;
    private Map<Integer, Node> nodesList;

    public UndirectedGraph() {
        adjList = new HashMap<>();
        nodesList = new HashMap<>();
    }

    public List<Node> getAllNodes() {
        return nodesList.values().stream().collect(toList());
    }

    public Set<Node> getAllConnectedNodes(int rootNodeName) throws NodeDoesNotExist {
        return adjList.get(getNodeById(rootNodeName)).keySet();
    }

    public boolean nodeExists(int nodeId) {
        return nodesList.containsKey(nodeId);
    }

    public boolean edgeExists(int node1, int node2) throws NodeDoesNotExist {
        assertNodeExists(node1);
        assertNodeExists(node2);
        Node n1 = getNodeById(node1);
        Node n2 = getNodeById(node2);
        return (adjList.get(n1).containsKey(n2) && adjList.get(n2).containsKey(n1));
    }

    public void createEdge(int node1, int node2) {
        this.createEdge(node1, node2, 0);
    }

    public void createEdge(int node1, int node2, int edgeWeight) {
        Node n1 = getNodeById(node1);
        Node n2 = getNodeById(node2);

        if (!adjList.containsKey(n1)) {
            adjList.put(n1, new HashMap<>());
        }

        if (!adjList.containsKey(n2)) {
            adjList.put(n2, new HashMap<>());
        }

        Edge edge = new Edge(edgeWeight);

        Map<Node, Set<Edge>> map = adjList.get(n1);
        if(adjList.get(n1).get(n2) == null) {
            map.put(n2, new HashSet<>());
        }
        map.get(n2).add(edge);

        map = adjList.get(n2);
        if(adjList.get(n2).get(n1) == null) {
            map.put(n1, new HashSet<>());
        }
        map.get(n1).add(edge);
    }

    public Node getNodeById(int nodeId) throws NodeDoesNotExist {
        assertNodeExists(nodeId);
        return nodesList.get(nodeId);
    }

    private void assertNodeExists(int nodeId) throws NodeDoesNotExist {
        if (!nodeExists(nodeId)) throw new NodeDoesNotExist();
    }

    public void add(Node node) throws NodeExists {
        if (nodeExists(node.getId())) throw new NodeExists();

        nodesList.put(node.getId(), node);
    }

    public class NodeExists extends RuntimeException {
    }

    public class NodeDoesNotExist extends RuntimeException {
    }
}
