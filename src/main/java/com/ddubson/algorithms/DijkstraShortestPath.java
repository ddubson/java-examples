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
            dijkstra(buildGraph(), retrieveStartNode());
        }
    }

    public static void dijkstra(UndirectedGraph graph, int source) {
        Set<Integer> nodes = new HashSet<>();
        int numOfNodes = graph.getNumberOfNodes();
        int[] dist = new int[numOfNodes+1];
        //int[] prev = new int[numOfNodes+1];

        for(int n : graph.getAllNodes()) {
            dist[n] = INFINITY;
            //prev[n.getId()] = INFINITY;
            nodes.add(n);
        }

        dist[source] = 0;

        while(!nodes.isEmpty()) {
            int node;
            try {
                node = findMinDistNode(nodes, dist);
            } catch(NodeNotFound e) {
                break;
            }
            nodes.remove(node);

            for(int neighbor : graph.getAllConnectedNodes(node)) {
                if(!nodes.contains(neighbor)) continue;

                int alt = dist[node] + distanceBetween(graph, node, neighbor);
                if(alt < dist[neighbor] || dist[neighbor] == INFINITY) {
                    dist[neighbor] = alt;
                    //prev[neighbor.getId()] = node.getId();
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            if(i == source) { continue; }
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

    private static int findMinDistNode(Set<Integer> nodes, int[] dist) throws NodeNotFound {
        int minNode = INFINITY;
        int shortestDist = INFINITY;
        for(int n : nodes) {
            if(shortestDist == INFINITY && dist[n] != INFINITY) {
                shortestDist = dist[n];
                minNode = n;
            }

            if(dist[n] < shortestDist && dist[n] != INFINITY) {
                shortestDist = dist[n];
                minNode = n;
            }
        }

        if(minNode == INFINITY) {
            throw new NodeNotFound();
        } else
            return minNode;
    }

    private static int retrieveStartNode() {
        return scanner.nextInt();
    }

    private static UndirectedGraph buildGraph() {
        int numOfNodes = scanner.nextInt();
        int numOfEdges = scanner.nextInt();

        UndirectedGraph g = new UndirectedGraph();
        for (int i = 1; i <= numOfNodes; i++) {
            if (!g.nodeExists(i)) {
                g.add(i);
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

    private static class NodeNotFound extends Exception {
    }
}

