package com.ddubson.datastructures.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
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
        graph.add(new Node(1));
        assertTrue(graph.nodeExists(1));
    }

    @Test(expected = UndirectedGraph.NodeExists.class)
    public void graph_shouldThrowErrorIfAddingNodeWithSameId() throws Exception {
        graph.add(new Node(1));
        graph.add(new Node(1));
    }

    @Test
    public void graph_shouldConnectTwoNodesSuccessfully() throws Exception {
        graph.add(new Node(1));
        graph.add(new Node(2));
        graph.createEdge(1, 2);
        assertTrue(graph.edgeExists(1, 2));
    }

    @Test(expected = UndirectedGraph.NodeDoesNotExist.class)
    public void graph_shouldFailToConnectNonExistentNodes() throws Exception {
        graph.createEdge(3, 4);
    }

    @Test(expected = UndirectedGraph.NodeDoesNotExist.class)
    public void graph_shouldFailToConnectNonExistentNodes2nd() throws Exception {
        graph.add(new Node(3));
        graph.createEdge(3, 4);
    }

    @Test
    public void graph_getAllConnectedNodesSuccessfully() throws Exception {
        graph.add(new Node(1));
        graph.add(new Node(2));
        graph.createEdge(1, 2);
        Set<Node> connectedToOne = graph.getAllConnectedNodes(1);
        Set<Node> connectedToTwo = graph.getAllConnectedNodes(2);
        assertTrue(connectedToOne.size()==1);
        assertTrue(connectedToTwo.size()==1);
        connectedToOne.forEach(node -> assertTrue(node.name==2));
        connectedToTwo.forEach(node -> assertTrue(node.name==1));
    }

    @Test
    public void graph_shouldGetAllNodes() throws Exception {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        graph.add(n1);
        graph.add(n2);
        graph.add(n3);
        List<Node> nodes = graph.getAllNodes();
        assertTrue(nodes.size()==3);
        assertTrue(nodes.contains(n1));
        assertTrue(nodes.contains(n2));
        assertTrue(nodes.contains(n3));
    }

    @Test
    public void graph_shouldReturnNodeIfExists() throws Exception {
        Node node = new Node(1);
        graph.add(node);
        assertEquals(node, graph.getNodeByName(1));
    }

    @Test(expected = UndirectedGraph.NodeDoesNotExist.class)
    public void graph_shouldThrowErrorIfNodeDoesNotExist() throws Exception {
        graph.getNodeByName(1);
    }
}