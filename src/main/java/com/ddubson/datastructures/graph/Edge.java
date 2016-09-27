package com.ddubson.datastructures.graph;

/**
 * Author: ddubson
 */
public class Edge {
    private int edgeWeight;
    private int origin;
    private int destination;

    public Edge(int edgeWeight, int origin, int destination) {
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

    public int getOrigin() {
        return origin;
    }

    public int getDestination() {
        return destination;
    }
}
