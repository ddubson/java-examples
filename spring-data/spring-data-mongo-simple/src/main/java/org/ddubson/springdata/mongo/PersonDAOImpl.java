package org.ddubson.springdata.mongo;

import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class PersonDAOImpl implements PersonDAO {
    private static final String PERSON_COLLECTION = "Person";
    private final MongoOperations mongoOps;

    public PersonDAOImpl(MongoOperations mongoOps) {
        this.mongoOps = mongoOps;
    }

    public void create(Person p) {
        this.mongoOps.insert(p, PERSON_COLLECTION);
    }

    public Person readById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return this.mongoOps.findOne(query, Person.class, PERSON_COLLECTION);
    }

    public void update(Person p) {
        this.mongoOps.save(p, PERSON_COLLECTION);
    }

    public int deleteById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        WriteResult result = this.mongoOps.remove(query, Person.class,
                PERSON_COLLECTION);
        return result.getN();
    }

    @Override
    public Person findOne(String personName) {
        return mongoOps.findOne(
                new Query(Criteria.where("name").is(personName)),
                Person.class, PERSON_COLLECTION);
    }

}
