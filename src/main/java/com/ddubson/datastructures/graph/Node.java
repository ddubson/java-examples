package com.ddubson.datastructures.graph;

/**
 * Author: ddubson
 */
public class Node {
    private boolean isStartingNode = false;
    public int distanceValue = -1;
    public boolean isVisited = false;
    public int name = -1;

    public Node(int name) {
        this.name = name;
    }

    public int getName() {
        return this.name;
    }

    public void setStartingNode(boolean startingNode) {
        isStartingNode = startingNode;
    }

    public boolean isStartingNode() {
        return isStartingNode;
    }
}
