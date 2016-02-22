package com.ddubson.datastructures.graph;

import com.ddubson.datastructures.graph.edge.Edge;
import com.ddubson.datastructures.graph.edge.impl.UndirectedEdge;
import com.ddubson.datastructures.graph.vertex.Vertex;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    Set<Vertex> vertices;
    Set<Edge> edges;

    public Graph() {
        this.vertices = new HashSet<>();
        this.edges = new HashSet<>();
    }

    public void addVertex(Vertex vertex) {
        this.vertices.add(vertex);
    }

    public Edge createEdge(Vertex v1, Vertex v2) {
        Edge e = new UndirectedEdge(v1, v2);
        this.edges.add(e);
        return e;
    }
}
