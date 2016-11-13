package com.ddubson.example.lambda.chaining_operations;

/**
 * Author: ddubson
 */
public class Coupling {
    private void open() {
        System.out.println("Opening resource...");
    }

    private void close() {
        System.out.println("Closing resource...");
    }

    public void operateOnResource(String s, Operation o) {
        this.open();
        o.operate(s);
        this.close();
    }

    public static void main(String... args) {
        Coupling c = new Coupling();
        c.operateOnResource("Hello", (s) -> System.out.println(s + ": operating."));
        c.operateOnResource("Hello", (s) -> System.out.println(s + ": another operation procedure"));
    }


}
