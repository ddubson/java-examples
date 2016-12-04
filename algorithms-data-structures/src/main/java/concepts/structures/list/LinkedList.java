package concepts.structures.list;

/**
 * Author: ddubson
 */
public interface LinkedList<T> {
    void addFirst(T item);

    void addLast(T item);

    T first();

    T last();

    T removeFirst();

    int size();

    boolean isEmpty();


}
