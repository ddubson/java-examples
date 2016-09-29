package com.ddubson.datastructures.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import static org.junit.Assert.assertTrue;

/**
 * Author: ddubson
 */
public class UndirectedGraphTest {
    UndirectedGraph graph;

    @Before
    public void setUp() throws Exception {
        graph = new UndirectedGraph();
    }

    @Test
    public void graph_shouldAddNodeSuccessfully() throws Exception {
        graph.add(1);
        assertTrue(graph.nodeExists(1));
    }

    @Test(expected = UndirectedGraph.NodeExists.class)
    public void graph_shouldThrowErrorIfAddingNodeWithSameId() throws Exception {
        graph.add(1);
        graph.add(1);
    }

    @Test
    public void graph_shouldConnectTwoNodesSuccessfully() throws Exception {
        graph.add(1);
        graph.add(2);
        graph.createEdge(1, 2);
        assertTrue(graph.edgeExists(1, 2));
    }

    @Test(expected = UndirectedGraph.NodeDoesNotExist.class)
    public void graph_shouldFailToConnectNonExistentNodes() throws Exception {
        graph.createEdge(3, 4);
    }

    @Test(expected = UndirectedGraph.NodeDoesNotExist.class)
    public void graph_shouldFailToConnectNonExistentNodes2nd() throws Exception {
        graph.add(3);
        graph.createEdge(3, 4);
    }

    @Test
    public void graph_getAllConnectedNodesSuccessfully() throws Exception {
        graph.add(1);
        graph.add(2);
        graph.createEdge(1, 2);
        Set<Integer> connectedToOne = graph.getAllConnectedNodes(1);
        Set<Integer> connectedToTwo = graph.getAllConnectedNodes(2);
        assertTrue(connectedToOne.size() == 1);
        assertTrue(connectedToTwo.size() == 1);
        connectedToOne.forEach(node -> assertTrue(node == 2));
        connectedToTwo.forEach(node -> assertTrue(node == 1));
    }

    @Test
    public void graph_shouldGetAllNodes() throws Exception {
        graph.add(1);
        graph.add(2);
        graph.add(3);
        Set<Integer> nodes = graph.getAllNodes();
        assertTrue(nodes.size() == 3);
        assertTrue(nodes.contains(1));
        assertTrue(nodes.contains(2));
        assertTrue(nodes.contains(3));
    }

    @Test(expected = UndirectedGraph.EdgeDoesNotExist.class)
    public void graph_shouldThrowErrorIfEdgeDoesNotExist() throws Exception {
        graph.add(1);
        graph.add(2);
        graph.getEdges(1, 2);
    }

    @Test(expected = UndirectedGraph.EdgeDoesNotExist.class)
    public void graph_shouldThrowErrorIfEdgeDoesNotExistButExistsOverAll() throws Exception {
        graph.add(1);
        graph.add(2);
        graph.add(3);
        graph.createEdge(1, 3);
        graph.getEdges(1, 2);
    }

    @Test
    public void graph_shouldFetchSingleExistingEdgeCorrectly() throws Exception {
        graph.add(1);
        graph.add(2);
        graph.createEdge(1, 2);
        Set<Edge> edges = graph.getEdges(1, 2);
        assertTrue(edges.size() == 1);
        edges.forEach(edge -> {
            assertTrue(edge.getEdgeWeight() == 0);
            assertTrue(edge.getOrigin() == 1);
            assertTrue(edge.getDestination() == 2);
        });
    }

    @Test
    public void graph_shouldBeAbleToAddMultipleEdges() throws Exception {
        graph.add(1);
        graph.add(2);
        graph.createEdge(1, 2);
        graph.createEdge(1, 2, 43);
        assertTrue(graph.edgeExists(1,2));
        assertTrue(graph.edgeExists(1, 2, 43));
    }
}