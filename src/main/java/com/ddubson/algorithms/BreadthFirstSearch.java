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
        Node startNode = g.getAllNodes().stream().filter(Node::isStartingNode).findFirst().get();
        startNode.distanceValue = 0;
        queuedNodes.add(startNode);

        while (!queuedNodes.isEmpty()) {
            Node currentNode = queuedNodes.remove();

            Set<Node> nodes = g.getAllConnectedNodes(currentNode.name);

            if (nodes == null) {
                continue;
            }

            List<Node> infNodes = nodes.stream()
                    .filter(n -> n.distanceValue == -1).collect(toList());

            infNodes.forEach(n -> {
                n.distanceValue = currentNode.distanceValue + DEFAULT_DISTANCE;
                queuedNodes.add(n);
            });
        }

        g.getAllNodes().stream().filter(node -> !node.isStartingNode()).forEach((node -> {
            System.out.print(node.distanceValue + " ");
        }));
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
        g.getNodeByName(startNodeName).setStartingNode(true);

        return g;
    }
}
