package com.ddubson.datastructures.graph.vertex.impl;

import com.ddubson.datastructures.graph.vertex.Vertex;

import java.util.UUID;

public class VertexImpl implements Vertex {
    final String id;

    public VertexImpl() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return this.id;
    }
}
