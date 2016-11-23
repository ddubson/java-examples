package concepts.structures.queue;

import java.util.NoSuchElementException;

/**
 * Created by ddubs on 11/23/2016.
 */
public interface Queue<E> {
    int size();

    boolean isEmpty();

    void enqueue(E e) throws IllegalStateException;

    /** aka peek() - view but do not remove first element **/
    E first() throws NoSuchElementException;

    /** remove the first element and return it back to caller **/
    E dequeue() throws NoSuchElementException;
}
