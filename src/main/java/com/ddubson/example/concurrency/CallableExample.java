package com.ddubson.example.concurrency;

import java.util.concurrent.*;

/**
 * Author: ddubson
 */
public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create 1-thread pool
        ExecutorService service = Executors.newFixedThreadPool(1);

        // Create a callable
        Callable<Integer> getNumber = () -> {
            TimeUnit.SECONDS.sleep(2);
            return 23;
        };

        // Submit callable for processing, and wait for response
        Future<Integer> number = service.submit(getNumber);
        System.out.println("Waiting");
        System.out.println("Result: "+number.get());
    }
}
