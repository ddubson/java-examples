package org.ddubson.springdata.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    @Autowired
    PersonDAO personDAO;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner app() {
        return (args) -> {
            // Create/insert entity class into collection
            Person p = new Person("Dmitriy", "New York, NY");
            personDAO.create(p);

            // Find the person using MongoOperations/Query/Criteria classes from
            // Spring Data
            Person p1 = personDAO.findOne("Dmitriy");
            System.out.println(p1);

            // Update location and print
            p1.setAddress("San Francisco, CA");
            personDAO.update(p1);

            p1 = personDAO.findOne("Dmitriy");
            System.out.println(p1);
        };
    }
}
