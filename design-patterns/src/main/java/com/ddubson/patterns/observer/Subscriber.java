package com.ddubson.patterns.observer;

/**
 * Author: ddubson
 */
public interface Subscriber {
    void update(Message message);
}
