package org.ddubson.springdata.mongo;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;

/**
 * Author: ddubson
 */
@Configuration
public class Config {
    public static final String DB_NAME = "people";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;

    @Bean
    public PersonDAO personDAO() throws UnknownHostException {
        return new PersonDAOImpl(mongoTemplate());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(mongoClient(), DB_NAME);
    }

    @Bean
    public MongoClient mongoClient() throws UnknownHostException {
        return new MongoClient(MONGO_HOST, MONGO_PORT);
    }
}
