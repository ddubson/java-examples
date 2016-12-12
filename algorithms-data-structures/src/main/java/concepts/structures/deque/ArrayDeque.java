package concepts.structures.deque;

import java.lang.reflect.Array;

/**
 * Author: ddubson
 */
public class ArrayDeque<E> implements Deque<E> {
    private final E[] deque;
    private int size;
    private int frontElementIndex;
    private int endElementIndex;

    @SuppressWarnings("unchecked")
    public ArrayDeque(int capacity) {
        this.deque = (E[]) Array.newInstance(Object.class, capacity);
        this.size = 0;
        this.frontElementIndex = 0;
        this.endElementIndex = 0;
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
    public E first() {
        return deque[frontElementIndex];
    }

    @Override
    public E last() {
        return deque[endElementIndex];
    }

    @Override
    public void addFirst(E e) {
        int emptySpot = 0;
        if (!isEmpty()) {
            // if deque is not empty, calculate the next "front" index.
            emptySpot = ((frontElementIndex - 1) + deque.length) % deque.length;
        } else {
            // if deque is empty, make sure the indices are aligned.
            frontElementIndex = 0;
            endElementIndex = 0;
        }

        deque[emptySpot] = e;
        frontElementIndex = emptySpot;
        size++;
    }

    @Override
    public void addLast(E e) {
        int emptySpot = (endElementIndex + size) % deque.length;
        deque[emptySpot] = e;
        endElementIndex = emptySpot;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E first = deque[frontElementIndex];
        deque[frontElementIndex] = null;
        frontElementIndex = (frontElementIndex + 1) % deque.length;
        size--;
        return first;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E last = deque[endElementIndex];
        deque[endElementIndex] = null;
        endElementIndex = ((endElementIndex - 1) + deque.length) % deque.length;
        size--;
        return last;
    }
}
