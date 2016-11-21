package com.ddubson.patterns.observer;

import org.junit.Test;

/**
 * Author: ddubson
 */
public class PublisherTest {
    @Test
    public void publisherTest() throws Exception {
        Subscriber s1 = new DumbSubscriber();
        Subscriber s2 = new DumbSubscriber();
        Observable observable = new Publisher();

        // Add subscribers to a publisher
        observable.attach(s1);
        observable.attach(s2);

        observable.addMessage(new Message("Hello World!"));
        observable.notifySubscribers();

        observable.addMessage(new Message("This is an update."));
        observable.notifySubscribers();

    }
}