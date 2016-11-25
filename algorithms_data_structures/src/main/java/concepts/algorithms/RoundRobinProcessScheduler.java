package concepts.algorithms;

import concepts.structures.queue.LinkedListQueue;
import concepts.structures.queue.Queue;

import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * Author: ddubson
 */
public class RoundRobinProcessScheduler {
    static final int delay = 100;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int capacity = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Queue<Process> processQueue = new LinkedListQueue<>(capacity);
        Stream.iterate(0, n -> n + 1).limit(10).forEach((i) -> processQueue.enqueue(new Process(i)));

        while (true) {
            Process process = processQueue.first();
            Future<Process> future = executorService.submit(process);
            future.get();
            //processQueue.rotate();
        }
    }

    static class Process implements Callable<Process> {
        int id;

        public Process(int id) {
            this.id = id;
        }

        @Override
        public Process call() {
            System.out.println(String.format("Running process %d", id));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this;
        }
    }
}
