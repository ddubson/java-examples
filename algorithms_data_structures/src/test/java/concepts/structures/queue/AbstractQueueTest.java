package concepts.structures.queue;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Author: ddubson
 */
public abstract class AbstractQueueTest {
    abstract int getCapacity();
    protected Queue<String> queue;

    @Test
    public void queue_shouldBeEmptyWhenInstantiated() throws Exception {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void queue_shouldBeSize0WhenInstantiated() throws Exception {
        assertThat(queue.size(), equalTo(0));
    }

    @Test
    public void queue_shouldBeAbleToQueueAnElement() throws Exception {
        queue.enqueue("Hello");
        assertThat(queue.first(), equalTo("Hello"));
    }

    @Test
    public void queue_shouldBeAbleToEnqueueMultipleElements() throws Exception {
        queue.enqueue("Hello");
        queue.enqueue("There");
        queue.enqueue("You");
        assertThat(queue.first(), equalTo("Hello"));
        assertThat(queue.size(), equalTo(3));
        assertThat(queue.isEmpty(), is(false));
    }

    @Test
    public void queue_shouldBeAbleToDequeueElements() throws Exception {
        queue.enqueue("Hello");
        queue.enqueue("There");
        assertThat(queue.size(), equalTo(2));
        assertThat(queue.first(), equalTo("Hello"));
        String s = queue.dequeue();
        assertThat(queue.size(), equalTo(1));
        assertThat(queue.first(), equalTo("There"));
        assertThat(s, equalTo("Hello"));
    }

    @Test(expected = IllegalStateException.class)
    public void queue_shouldThrowIllegalStateExceptionUponBreachCapacity() throws Exception {
        Stream.iterate(0, (s) -> s + 1).limit(getCapacity() + 1).forEach((i) -> queue.enqueue("hey" + i));
    }

    @Test(expected = NoSuchElementException.class)
    public void queue_shouldThrowNoSuchElementExceptionWhenDequeuingEmptyQueue() throws Exception {
        queue.dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void queue_shouldThrowNoSuchElementExceptionWhenFirstIsCalledOnAnEmptyQueue() throws Exception {
        queue.first();
    }
}
