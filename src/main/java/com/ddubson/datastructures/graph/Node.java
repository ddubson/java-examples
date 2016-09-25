package com.ddubson.datastructures.graph;

/**
 * Author: ddubson
 */
public class Node {
    private boolean isStartNode = false;
    private int distanceValue = -1;
    private int id = -1;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setStartNode(boolean startNode) {
        isStartNode = startNode;
    }

    public boolean isStartNode() {
        return isStartNode;
    }

    public void setDistanceValue(int distanceValue) {
        this.distanceValue = distanceValue;
    }

    public int getDistanceValue() {
        return distanceValue;
    }
}
