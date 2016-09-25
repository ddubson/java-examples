package com.ddubson.algorithms;

import com.ddubson.datastructures.graph.Graph;
import com.ddubson.datastructures.graph.Node;
import com.ddubson.datastructures.graph.UndirectedGraph;

import java.util.Scanner;

/**
 * Author: ddubson
 */

public class DijkstraShortestPath {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int numOfQueries = scanner.nextInt();
        for (int i = 0; i < numOfQueries; i++) {
            dijkstra();
        }
    }

    public static void dijkstra() {
        Graph graph = buildGraph();
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

        int startNodeName = scanner.nextInt();
        g.getNodeById(startNodeName).setStartNode(true);

        return g;
    }
}

