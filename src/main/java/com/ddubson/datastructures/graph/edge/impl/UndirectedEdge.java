package com.ddubson.datastructures.graph.edge.impl;

import com.ddubson.datastructures.graph.edge.Edge;
import com.ddubson.datastructures.graph.vertex.Vertex;
import org.apache.commons.lang3.tuple.ImmutablePair;

/**
 * Created by ddubson on 2/21/16.
 */
public class UndirectedEdge implements Edge {
    final ImmutablePair<Vertex, Vertex> vertices;

    public UndirectedEdge(Vertex v1, Vertex v2) {
        this.vertices = new ImmutablePair<>(v1, v2);
    }

    @Override
    public ImmutablePair getVertices() {
        return this.vertices;
    }
}
