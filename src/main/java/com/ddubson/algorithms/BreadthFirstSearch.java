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
    Scanner scanner;


    public BreadthFirstSearch(Scanner scanner) {
        this.scanner = scanner;

        int numOfQueries = scanner.nextInt();
        for (int i = 0; i < numOfQueries; i++) {
            breadthFirstSearch();
        }
    }

    public static void main(String[] args) {
        new BreadthFirstSearch(new Scanner(System.in));
    }

    private void breadthFirstSearch() {
        UndirectedGraph g = buildGraph();
        Queue<Node> queuedNodes = new LinkedList<>();
        Node startNode = g.getAllNodes().stream().filter(Node::isStartNode).findFirst().get();
        startNode.setDistanceValue(0);
        queuedNodes.add(startNode);

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

    private UndirectedGraph buildGraph() {
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
        int startNodeName = scanner.nextInt();
        g.getNodeById(startNodeName).setStartNode(true);

        return g;
    }
}
