package com.ddubson.datastructures.graph;


import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Author: ddubson
 */
public class UndirectedGraph implements Graph {
    // node <-> node --> edge map
    private Map<Node, Map<Node, UUID>> adjList;
    private Map<Integer, Node> nodesList;
    private Map<UUID, Set<Edge>> edgeMap;

    public UndirectedGraph() {
        adjList = new HashMap<>();
        nodesList = new HashMap<>();
        edgeMap = new HashMap<>();
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

        if (adjList.get(n1) == null || adjList.get(n1).get(n2) == null) {
            return false;
        }

        return edgeMap.get(adjList.get(n1).get(n2)).stream().filter(edge -> edge.getEdgeWeight() == edgeWeight)
                .findFirst().isPresent();
    }

    private Node fetchNodeIfExists(int node1) {
        assertNodeExists(node1);
        return getNodeById(node1);
    }

    public Set<Edge> getEdges(int node1, int node2) throws EdgeDoesNotExist, NodeDoesNotExist {
        Node n1 = fetchNodeIfExists(node1);
        Node n2 = fetchNodeIfExists(node2);
        assumeEdgesExist(n1, n2);
        return edgeMap.get(adjList.get(n1).get(n2));
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

        Edge edge = new Edge(edgeWeight, n1, n2);
        if(adjList.get(n1) != null && adjList.get(n1).get(n2) != null) {
            UUID uuid = adjList.get(n1).get(n2);
            edgeMap.get(uuid).add(edge);
        } else {
            UUID uuid = UUID.randomUUID();
            edgeMap.putIfAbsent(uuid, new HashSet<>());
            edgeMap.get(uuid).add(edge);

            adjList.putIfAbsent(n1, new HashMap<>());
            adjList.putIfAbsent(n2, new HashMap<>());
            adjList.get(n1).put(n2, uuid);
            adjList.get(n2).put(n1, uuid);
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
