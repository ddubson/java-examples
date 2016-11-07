package com.ddubson.example.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import java.util.Map;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLObjectType.newObject;

/**
 * Author: ddubson
 */
public class HelloWorld {
    public static void main(String[] args) {
        GraphQLObjectType queryType = newObject()
                .name("bookQuery")
                .field(field -> field
                        .type(GraphQLString)
                        .name("book")
                        .dataFetcher(environment -> "hello"))
                .build();
        System.out.println(queryType);

        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();

        GraphQL graphQL = new GraphQL(schema);
        Map<String, Object> result = (Map<String, Object>) graphQL.execute("{book}").getData();

        System.out.println(result);
        // Prints: {hello=world}
    }
}
