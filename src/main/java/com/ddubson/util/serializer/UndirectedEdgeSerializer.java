package com.ddubson.util.serializer;

import com.ddubson.datastructures.graph.edge.impl.UndirectedEdge;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by ddubson on 2/21/16.
 */
public class UndirectedEdgeSerializer extends JsonSerializer<UndirectedEdge> {
    @Override
    public void serialize(UndirectedEdge value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeStringField("vertex 1", value.getVertices().getLeft().toString());
        gen.writeStringField("vertex 2", value.getVertices().getRight().toString());
        gen.writeEndObject();
    }
}
