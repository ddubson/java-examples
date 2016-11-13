package com.ddubson.patterns.observer;

/**
 * Author: ddubson
 */
public class Message {
    String message;

    public Message(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }
}
