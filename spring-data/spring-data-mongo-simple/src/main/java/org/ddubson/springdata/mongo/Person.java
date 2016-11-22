package org.ddubson.springdata.mongo;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Person {

    // id will be used for storing MongoDB _id
    @Id
    private UUID id;

    private String name;
    private String address;

    public Person() {
    }

    public Person(String n, String a) {
        this.id = UUID.randomUUID();
        this.name = n;
        this.address = a;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return id + "::" + name + "::" + address;
    }
}
