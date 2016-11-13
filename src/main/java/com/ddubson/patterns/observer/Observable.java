package com.ddubson.patterns.observer;

/**
 * Author: ddubson
 */
public interface Observable {
    void attach(Subscriber subscriber);

    void notifySubscribers();

    void addMessage(Message message);
}
