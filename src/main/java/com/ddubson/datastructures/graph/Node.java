package com.ddubson.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: ddubson
 */
public class Node {
    public boolean isStartingNode = false;
    public int distanceValue = -1;
    public boolean isVisited = false;
    public int name = -1;
    public Map<Integer, List<Edge>> adjList;

    public Node() {
        adjList = new HashMap<>();
    }

    public void addEdge(Integer nodeKey, Edge e) {
        if(adjList.containsKey(nodeKey)){
            adjList.get(nodeKey).add(e);
        } else {
            ArrayList edg = new ArrayList<>();
            edg.add(e);
            adjList.put(nodeKey,edg);
        }
    }
}
