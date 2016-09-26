package com.ddubson.algorithms;

import com.ddubson.datastructures.graph.Edge;
import com.ddubson.datastructures.graph.Node;
import com.ddubson.datastructures.graph.UndirectedGraph;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Author: ddubson
 */
public class DijkstraShortestPath {
    private static int INFINITY = -1;
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int numOfQueries = scanner.nextInt();
        for (int i = 0; i < numOfQueries; i++) {
            UndirectedGraph graph = buildGraph();
            Node source = setAndRetrieveStartNode(graph);
            dijkstra(graph, source);
        }
    }

    public static void dijkstra(UndirectedGraph graph, Node source) {
        Set<Node> nodes = new HashSet<>();
        int numOfNodes = graph.getAllNodes().size();
        int[] dist = new int[numOfNodes+1];
        //int[] prev = new int[numOfNodes+1];

        for(Node n : graph.getAllNodes()) {
            dist[n.getId()] = INFINITY;
            //prev[n.getId()] = INFINITY;
            nodes.add(n);
        }

        dist[source.getId()] = 0;

        while(!nodes.isEmpty()) {
            Node node = findMinDistNode(nodes, dist);
            if(node == null) break;
            nodes.remove(node);

            for(Node neighbor : graph.getAllConnectedNodes(node.getId())) {
                if(!nodes.contains(neighbor)) continue;

                int alt = dist[node.getId()] + distanceBetween(graph, node.getId(), neighbor.getId());
                if(alt < dist[neighbor.getId()] || dist[neighbor.getId()] == INFINITY) {
                    dist[neighbor.getId()] = alt;
                    //prev[neighbor.getId()] = node.getId();
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            if(i == source.getId()) { continue; }
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    private static int distanceBetween(UndirectedGraph graph, int nodeId, int neighborId) {
        // get edge(s) between two nodes
        int shortestDistance = INFINITY;
        for(Edge e : graph.getEdges(nodeId, neighborId)) {
            if(shortestDistance == INFINITY) {
                shortestDistance = e.getEdgeWeight();
            }

            if(e.getEdgeWeight() < shortestDistance) {
                shortestDistance = e.getEdgeWeight();
            }
        }

        return shortestDistance;
    }

    private static Node findMinDistNode(Set<Node> nodes, int[] dist) {
        Node minNode = null;
        int shortestDist = INFINITY;
        for(Node n : nodes) {
            if(shortestDist == INFINITY && dist[n.getId()] != INFINITY) {
                shortestDist = dist[n.getId()];
                minNode = n;
            }

            if(dist[n.getId()] < shortestDist && dist[n.getId()] != INFINITY) {
                shortestDist = dist[n.getId()];
                minNode = n;
            }
        }

        return minNode;
    }

    private static Node setAndRetrieveStartNode(UndirectedGraph graph) {
        int startNodeName = scanner.nextInt();
        Node n = graph.getNodeById(startNodeName);
        n.setStartNode(true);
        return n;
    }

    private static UndirectedGraph buildGraph() {
        UndirectedGraph g = new UndirectedGraph();
        int numOfNodes = scanner.nextInt();
        int numOfEdges = scanner.nextInt();

        for (int i = 1; i <= numOfNodes; i++) {
            if (!g.nodeExists(i)) {
                g.add(new Node(i));
            }
        }

        for (int i = 0; i < numOfEdges; i++) {
            int originNodeName = scanner.nextInt();
            int destinationNodeName = scanner.nextInt();
            int edgeWeight = scanner.nextInt();
            g.createEdge(originNodeName, destinationNodeName, edgeWeight);
        }

        return g;
    }
}

