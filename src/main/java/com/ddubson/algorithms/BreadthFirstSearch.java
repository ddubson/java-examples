package com.ddubson.algorithms;

import com.ddubson.datastructures.graph.Node;
import com.ddubson.datastructures.graph.UndirectedGraph;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Author: ddubson
 */
public class BreadthFirstSearch {
    private static final int DEFAULT_DISTANCE = 6;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numOfQueries = scanner.nextInt();
        for (int i = 0; i < numOfQueries; i++) {
            UndirectedGraph graph = buildGraph();
            Node source = setAndRetrieveStartNode(graph);
            breadthFirstSearch(graph, source);
        }
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
            g.createEdge(originNodeName, destinationNodeName);
        }

        return g;
    }

    private static Node setAndRetrieveStartNode(UndirectedGraph graph) {
        int startNodeName = scanner.nextInt();
        Node n = graph.getNodeById(startNodeName);
        n.setStartNode(true);
        return n;
    }

    public static void breadthFirstSearch(UndirectedGraph g, Node sourceNode) {
        Queue<Node> queuedNodes = new LinkedList<>();
        sourceNode.setDistanceValue(0);
        queuedNodes.add(sourceNode);

        while (!queuedNodes.isEmpty()) {
            Node currentNode = queuedNodes.remove();

            Set<Node> nodes = g.getAllConnectedNodes(currentNode.getId());

            if (nodes == null) {
                continue;
            }

            List<Node> infNodes = nodes.stream()
                    .filter(n -> n.getDistanceValue() == -1).collect(toList());

            infNodes.forEach(n -> {
                n.setDistanceValue(currentNode.getDistanceValue() + DEFAULT_DISTANCE);
                queuedNodes.add(n);
            });
        }

        g.getAllNodes().stream().filter(node -> !node.isStartNode()).forEach((node -> System.out.print(node.getDistanceValue() + " ")));
        System.out.println();
    }
}
