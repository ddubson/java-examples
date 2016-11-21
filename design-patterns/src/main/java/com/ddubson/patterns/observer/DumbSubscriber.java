package com.ddubson.patterns.observer;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Author: ddubson
 */
public class DumbSubscriber implements Subscriber {
    final UUID id;
    Set<Message> consumed;

    public DumbSubscriber() {
        this.id = UUID.randomUUID();
        this.consumed = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                '}';
    }

    public void update(Message message) {
        this.consumed.add(message);
        System.out.println(this + " consumed '" + message.getMessage() + "'");
    }
}
