package com.ddubson.datastructures.graph;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Author: ddubson
 */
public class UndirectedGraphTest {
    @Test
    public void graph_shouldAddNodeSuccessfully() throws Exception {
        UndirectedGraph graph = new UndirectedGraph();
        graph.add(new Node(1));
        assertTrue(graph.nodeExists(1));
    }

    @Test(expected = UndirectedGraph.NodeExists.class)
    public void graph_shouldThrowErrorIfAddingNodeWithSameId() throws Exception {
        UndirectedGraph graph = new UndirectedGraph();
        graph.add(new Node(1));
        graph.add(new Node(1));
    }
}