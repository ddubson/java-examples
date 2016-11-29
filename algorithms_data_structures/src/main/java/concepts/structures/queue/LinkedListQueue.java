package concepts.structures.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Author: ddubson
 */
public class LinkedListQueue<E> implements Queue<E>{
    List<E> queue;
    final int capacity;

    public LinkedListQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public void enqueue(E e) throws IllegalStateException {
        if(capacity==this.queue.size()) throw new IllegalStateException();
        this.queue.add(e);
    }

    @Override
    public E first() throws NoSuchElementException {
        if(isEmpty()) throw new NoSuchElementException();
        return this.queue.get(0);
    }

    @Override
    public E dequeue() throws NoSuchElementException {
        if(isEmpty()) throw new NoSuchElementException();
        return this.queue.remove(0);
    }
}
