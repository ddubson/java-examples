package com.ddubson.datastructures.graph;

import com.ddubson.datastructures.graph.edge.Edge;
import com.ddubson.datastructures.graph.vertex.Vertex;
import com.ddubson.datastructures.graph.vertex.impl.VertexImpl;
import com.ddubson.util.Json;
import com.fasterxml.jackson.core.JsonProcessingException;

public class GraphApp {
    public static void main(String... args) throws JsonProcessingException {
        Graph g = new Graph();
        Vertex v1 = new VertexImpl();
        Vertex v2 = new VertexImpl();
        g.addVertex(v1);
        g.addVertex(v2);
        Edge e = g.createEdge(v1, v2);
        System.out.print(Json.toJsonString(e));
    }
}
