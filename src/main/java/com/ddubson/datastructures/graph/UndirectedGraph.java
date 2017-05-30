package com.ddubson.datastructures.graph;


import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Author: ddubson
 */
public class UndirectedGraph implements Graph {
    private Map<Node, Map<Node, Set<Edge>>> adjList;
    private Map<Integer, Node> nodesList;
    private List<Edge> edgeList;

    public UndirectedGraph() {
        adjList = new HashMap<>();
        nodesList = new HashMap<>();
        edgeList = new ArrayList<>();
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

    public boolean edgeExists(int node1, int node2) {
        return this.edgeExists(node1, node2, 0);
    }

    public boolean edgeExists(int node1, int node2, int edgeWeight) throws NodeDoesNotExist {
        Node n1 = fetchNodeIfExists(node1);
        Node n2 = fetchNodeIfExists(node2);

        return edgeList.stream().anyMatch(edge -> edge.getEdgeWeight() == edgeWeight &&
                ((edge.getOrigin() == n1 && edge.getDestination() == n2) ||
                        (edge.getDestination() == n2 && edge.getOrigin() == n1)));
    }

    private Node fetchNodeIfExists(int node1) {
        assertNodeExists(node1);
        return getNodeById(node1);
    }

    public Set<Edge> getEdges(int node1, int node2) throws EdgeDoesNotExist, NodeDoesNotExist {
        Node n1 = fetchNodeIfExists(node1);
        Node n2 = fetchNodeIfExists(node2);
        assumeEdgesExist(n1, n2);
        return adjList.get(n1).get(n2);
    }

    private void assumeEdgesExist(Node n1, Node n2) throws EdgeDoesNotExist {
        if (adjList.get(n1) == null || adjList.get(n1).get(n2) == null) {
            throw new EdgeDoesNotExist();
        }
    }

    public void createEdge(int node1, int node2) {
        this.createEdge(node1, node2, 0);
    }

    public void createEdge(int node1, int node2, int edgeWeight) {
        Node n1 = fetchNodeIfExists(node1);
        Node n2 = fetchNodeIfExists(node2);

        createAdjancencyMapIfNull(n1);
        createAdjancencyMapIfNull(n2);

        Edge edge = new Edge(edgeWeight, n1, n2);

        Map<Node, Set<Edge>> map = adjList.get(n1);
        createEdgeMapIfNull(n1, n2, map);
        map.get(n2).add(edge);

        map = adjList.get(n2);
        createEdgeMapIfNull(n2, n1, map);
        map.get(n1).add(edge);

        edgeList.add(edge);
    }

    private void createEdgeMapIfNull(Node n1, Node n2, Map<Node, Set<Edge>> map) {
        if (adjList.get(n1).get(n2) == null) {
            map.put(n2, new HashSet<>());
        }
    }

    private void createAdjancencyMapIfNull(Node n1) {
        if (!adjList.containsKey(n1)) {
            adjList.put(n1, new HashMap<>());
        }
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

    public class EdgeDoesNotExist extends RuntimeException {
    }
}
