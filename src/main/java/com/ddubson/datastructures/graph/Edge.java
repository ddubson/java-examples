package com.ddubson.datastructures.graph;

/**
 * Author: ddubson
 */
public class Edge {
    private int edgeWeight;
    private Node origin;
    private Node destination;

    public Edge(int edgeWeight, Node origin, Node destination) {
        this.edgeWeight = edgeWeight;
        this.origin = origin;
        this.destination = destination;
    }

    public Edge() {
        this.edgeWeight = 0;
    }

    public int getEdgeWeight() {
        return edgeWeight;
    }

    public Node getOrigin() {
        return origin;
    }

    public Node getDestination() {
        return destination;
    }
}
