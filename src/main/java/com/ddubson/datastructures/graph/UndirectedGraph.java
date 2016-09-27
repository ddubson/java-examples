package com.ddubson.datastructures.graph;


import java.util.*;

public class UndirectedGraph implements Graph {
    // node <-> node --> edge map
    private Map<Integer, Map<Integer, UUID>> adjList;
    private Map<UUID, Set<Edge>> edgeMap;

    public UndirectedGraph() {
        adjList = new HashMap<>();
        edgeMap = new HashMap<>();
    }

    public Set<Integer> getAllNodes() {
        return adjList.keySet();
    }

    public int getNumberOfNodes() {
        return adjList.keySet().size();
    }

    public Set<Integer> getAllConnectedNodes(int rootNodeName) throws NodeDoesNotExist {
        return adjList.get(rootNodeName).keySet();
    }

    public boolean nodeExists(int nodeId) {
        return adjList.containsKey(nodeId);
    }

    public boolean edgeExists(int node1, int node2) {
        return this.edgeExists(node1, node2, 0);
    }

    public boolean edgeExists(int node1, int node2, int edgeWeight) throws NodeDoesNotExist {
        if (adjList.get(node1) == null || adjList.get(node1).get(node2) == null) {
            return false;
        }

        return edgeMap.get(adjList.get(node1).get(node2)).stream().filter(edge -> edge.getEdgeWeight() == edgeWeight)
                .findFirst().isPresent();
    }

    public Set<Edge> getEdges(int node1, int node2) throws EdgeDoesNotExist, NodeDoesNotExist {
        assumeEdgesExist(node1, node2);
        return edgeMap.get(adjList.get(node1).get(node2));
    }

    private void assumeEdgesExist(int n1, int n2) throws EdgeDoesNotExist {
        if (adjList.get(n1) == null || adjList.get(n1).get(n2) == null) {
            throw new EdgeDoesNotExist();
        }
    }

    public void createEdge(int node1, int node2) {
        this.createEdge(node1, node2, 0);
    }

    public void createEdge(int node1, int node2, int edgeWeight) throws NodeDoesNotExist {
        assertNodeExists(node1);
        assertNodeExists(node2);
        Edge edge = new Edge(edgeWeight, node1, node2);
        if (adjList.get(node1) != null && adjList.get(node1).get(node2) != null) {
            UUID uuid = adjList.get(node1).get(node2);
            edgeMap.get(uuid).add(edge);
        } else {
            UUID uuid = UUID.randomUUID();
            edgeMap.putIfAbsent(uuid, new HashSet<>());
            edgeMap.get(uuid).add(edge);

            //adjList.putIfAbsent(n1, new HashMap<>());
            //adjList.putIfAbsent(n2, new HashMap<>());
            adjList.get(node1).put(node2, uuid);
            adjList.get(node2).put(node1, uuid);
        }
    }


    private void assertNodeExists(int nodeId) throws NodeDoesNotExist {
        if (!nodeExists(nodeId)) throw new NodeDoesNotExist();
    }

    public void add(int node) throws NodeExists {
        if (nodeExists(node)) throw new NodeExists();

        adjList.putIfAbsent(node, new HashMap<>());
    }

    public class NodeExists extends RuntimeException {
    }

    public class NodeDoesNotExist extends RuntimeException {
    }

    public class EdgeDoesNotExist extends RuntimeException {
    }
}
