package com.ddubson.example.concurrency.producer_consumer;

import java.util.UUID;

/**
 * Created by ddubson on 10/20/2016.
 */
public class Message {
    private UUID id;

    public Message() {
        this.id = UUID.randomUUID();
    }

    public Message(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
