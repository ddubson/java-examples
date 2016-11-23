package concepts.structures.queue;

/**
 * Created by ddubs on 11/23/2016.
 */
public interface Queue<E> {
    int size();

    boolean isEmpty();

    void enqueue(E e);

    /** aka peek() - view but do not remove first element **/
    E first();

    /** remove the first element and return it back to caller **/
    E dequeue();
}
