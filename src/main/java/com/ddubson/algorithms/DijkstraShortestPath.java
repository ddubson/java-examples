package com.ddubson.algorithms;
/*
import com.ddubson.datastructures.graph.Edge;
import com.ddubson.datastructures.graph.Graph;
import com.ddubson.datastructures.graph.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

*/

/**
 * Author: ddubson
 */

public class DijkstraShortestPath {
    /*public DijkstraShortestPath() {
    }

    public void run() throws IOException {
        InputStream in = getClass().getResourceAsStream("/input.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int numOfCases = Integer.parseInt(reader.readLine());

        for (int f = 0; f < numOfCases; f++) {
            int[] n = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int numOfNodes = n[0];
            int numOfEdges = n[1];

            // create Graph from the edges
            Graph graph = genGraph(numOfNodes, numOfEdges, reader);

            // Set the starting node
            int startNodeKey = Integer.parseInt(reader.readLine());
            Node node = graph.findNodeByKey(startNodeKey);
            node.isStartingNode = true;
            dijkstra(graph, node);
        }
    }

    public void dijkstra(Graph g, Node startingNode) {
        // Run Dijkstra's Algorithm - generate list of shortest paths
        Node currentNode = startingNode;
        currentNode.distanceValue = 0;


        for(Map.Entry<Integer, List<Edge>> adjacents : currentNode.adjList.entrySet()) {
            Node adjNode = g.findNodeByKey(adjacents.getKey());
            for(Edge e : adjacents.getValue()) {
                if(currentNode.distanceValue + e.edgeWeight < adjNode.distanceValue) {
                    adjNode.distanceValue = currentNode.distanceValue + e.edgeWeight;
                }
            }
        }
        currentNode.isVisited = true;


    }

    public static void main(String[] args) throws IOException {
        new DijkstraShortestPath().run();
    }

    public static Graph genGraph(int numOfNodes, int numOfEdges, BufferedReader r) throws IOException {
        Graph g = new Graph();

        for(int y = 0; y < numOfEdges; y++) {
            int[] edges = Arrays.stream(r.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int nodeKey = edges[0];
            int adjNodeKey = edges[1];
            int edgeWeight = edges[2];

            Edge e = new Edge();
            e.edgeWeight = edgeWeight;

            if(!g.nodeExists(nodeKey)) {
                Node node = new Node();
                node.name = nodeKey;
                node.addEdge(adjNodeKey, e);
                g.put(node);
            } else {
                g.findNodeByKey(nodeKey).addEdge(adjNodeKey, e);
            }

            if(!g.nodeExists(adjNodeKey)) {
                Node destNode = new Node();
                destNode.name = adjNodeKey;
                destNode.addEdge(nodeKey, e);
                g.put(destNode);
            } else {
                g.findNodeByKey(adjNodeKey).addEdge(nodeKey, e);
            }
        }

        return g;
    }*/
}

