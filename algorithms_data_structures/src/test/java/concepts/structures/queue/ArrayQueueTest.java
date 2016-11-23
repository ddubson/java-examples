package concepts.structures.queue;

import org.junit.Before;
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
public class ArrayQueueTest {
    final int capacity = 10;
    Queue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new ArrayQueue<>(capacity);
    }

    @Test
    public void arrayQueue_shouldBeEmptyWhenInstantiated() throws Exception {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void arrayQueue_shouldBeSize0WhenInstantiated() throws Exception {
        assertThat(queue.size(), equalTo(0));
    }

    @Test
    public void arrayQueue_shouldBeAbleToQueueAnElement() throws Exception {
        queue.enqueue("Hello");
        assertThat(queue.first(), equalTo("Hello"));
    }

    @Test
    public void arrayQueue_shouldBeAbleToEnqueueMultipleElements() throws Exception {
        queue.enqueue("Hello");
        queue.enqueue("There");
        queue.enqueue("You");
        assertThat(queue.first(), equalTo("Hello"));
        assertThat(queue.size(), equalTo(3));
        assertThat(queue.isEmpty(), is(false));
    }

    @Test
    public void arrayQueue_shouldBeAbleToDequeueElements() throws Exception {
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
    public void arrayQueue_shouldThrowIllegalStateExceptionUponBreachCapacity() throws Exception {
        Stream.iterate(0, (s) -> s + 1).limit(capacity + 1).forEach((i) -> queue.enqueue("hey" + i));
    }

    @Test(expected = NoSuchElementException.class)
    public void arrayQueue_shouldThrowNoSuchElementExceptionWhenDequeuingEmptyQueue() throws Exception {
        queue.dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void arrayQueue_shouldThrowNoSuchElementExceptionWhenFirstIsCalledOnAnEmptyQueue() throws Exception {
        queue.first();
    }
}