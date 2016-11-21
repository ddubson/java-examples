package concurrency.producer_consumer;

import java.util.concurrent.*;

/**
 * Created by ddubson on 10/20/2016.
 */
public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(producer);
        service.submit(consumer);
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }
}
