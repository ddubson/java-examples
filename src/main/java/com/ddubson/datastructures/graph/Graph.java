package com.ddubson.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    Map<Integer, Node> nodes;

    public Graph() {
        nodes = new HashMap<>();
    }

    public List<Node> getAllNodes() {
        return (ArrayList<Node>) nodes.values();
    }

    public boolean nodeExists(Integer key) {
        return nodes.containsKey(key);
    }

    public boolean edgeExists(Integer key1, Integer key2) {
        if(!nodeExists(key1) || !nodeExists(key2)) {
            return false;
        }
        return false;

        //Node n1 = findNodeByKey(key1);
    }

    public Node findNodeByKey(Integer key) {
        if(nodes.containsKey(key)) {
            return nodes.get(key);
        } else {
            return null;
        }
    }

    public void put(Node node) {
        if(!nodes.containsKey(node.name)) {
            nodes.put(node.name, node);
        }
    }
}
