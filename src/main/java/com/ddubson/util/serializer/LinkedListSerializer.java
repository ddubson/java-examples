package com.ddubson.util.serializer;

import com.ddubson.datastructures.lists.LinkedList;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by d.dubson on 2/22/2016.
 */
public class LinkedListSerializer extends JsonSerializer<LinkedList> {
	@Override
	public void serialize(LinkedList value, JsonGenerator gen,
			SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeStartObject();
		gen.writeEndObject();
	}
}
