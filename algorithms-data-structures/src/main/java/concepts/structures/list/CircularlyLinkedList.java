package concepts.structures.list;

/**
 * Author: ddubson
 */
public interface CircularlyLinkedList<T> extends LinkedList<T> {
    /** moves the first element to the end of the list **/
    void rotate();
}
