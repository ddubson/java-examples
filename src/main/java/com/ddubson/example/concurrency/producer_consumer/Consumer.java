package com.ddubson.example.concurrency.producer_consumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by ddubson on 10/20/2016.
 */
public class Consumer implements Runnable{
    private final BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Message msg = null;
            while((msg = queue.take()).getId() != null) {
                System.out.println("Consumed: " + msg.getId());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
