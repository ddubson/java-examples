package com.ddubson.patterns.observer;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: ddubson
 */
public class Publisher implements Observable {
    Set<Subscriber> subscribers;
    Set<Message> messages;
    Message lastMessageAdded;

    public Publisher() {
        this.subscribers = new HashSet<>();
        this.messages = new HashSet<>();
    }

    @Override
    public void attach(Subscriber subscriber) {
        this.subscribers.add(subscriber);
        System.out.println(subscriber + " added.");
    }

    @Override
    public void notifySubscribers() {
        this.subscribers.forEach(subscriber -> subscriber.update(lastMessageAdded));
    }

    @Override
    public void addMessage(Message message) {
        this.messages.add(message);
        this.lastMessageAdded = message;
    }
}
