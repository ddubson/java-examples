package concurrency.producer_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

/**
 * Created by ddubson on 10/20/2016.
 */
public class Producer implements Runnable {
    private final BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Stream.iterate(0, n -> n + 1).limit(100).forEach(getIntegerConsumer());
            this.queue.put(new Message(null));
        } catch(InterruptedException e) {}
    }

    private java.util.function.Consumer<Integer> getIntegerConsumer() {
        return n -> {
            try {
                Message msg = new Message();
                this.queue.put(msg);
                System.out.println("Produced: " + msg.getId());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

}
