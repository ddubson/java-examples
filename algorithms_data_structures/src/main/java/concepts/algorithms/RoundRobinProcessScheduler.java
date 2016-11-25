package concepts.algorithms;

import concepts.structures.queue.CircularQueue;
import concepts.structures.queue.LinkedListQueue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

/**
 * Author: ddubson
 */
public class RoundRobinProcessScheduler {
    static final int delay = 100;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int capacity = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CircularQueue<Process> processQueue = new LinkedListQueue<>(capacity);

        Stream.iterate(0, n -> n + 1).limit(10).forEach((i) -> processQueue.enqueue(new Process(i)));
        Stream.iterate(0, n -> n + 1).forEach(i -> {
            executorService.submit(processQueue.first());
            processQueue.rotate();
        });

    }

    static class Process implements Runnable {
        int id;

        public Process(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(String.format("Running process %d | Thread %s", id, Thread.currentThread().getName()));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
