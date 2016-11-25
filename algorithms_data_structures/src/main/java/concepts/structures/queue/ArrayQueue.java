package concepts.structures.queue;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * Author: ddubson
 */
public class ArrayQueue<E> implements CircularQueue<E> {
    private final E[] queue;
    private int size;
    private int frontElementIndex;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.queue = (E[]) Array.newInstance(Object.class, capacity);
        this.size = 0;
        this.frontElementIndex = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) throws IllegalStateException {
        if (size == queue.length) throw new IllegalStateException();
        int emptySpot = (frontElementIndex + size) % queue.length;
        queue[emptySpot] = e;
        size++;
    }

    @Override
    public E first() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[frontElementIndex];
    }

    @Override
    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E toRemove = queue[frontElementIndex];
        queue[frontElementIndex] = null;
        frontElementIndex = (frontElementIndex + 1) % queue.length;
        size--;
        return toRemove;
    }

    @Override
    public void rotate() {
        if(isEmpty() || size()==1) return;
        enqueue(dequeue());
    }
}
