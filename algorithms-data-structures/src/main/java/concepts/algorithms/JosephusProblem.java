package concepts.algorithms;

import concepts.structures.queue.CircularQueue;
import concepts.structures.queue.LinkedListQueue;

import java.util.stream.Stream;

/**
 * Author: ddubson
 */
public class JosephusProblem {
    public static <E> CircularQueue<E> buildQueue(E a[]) {
        CircularQueue<E> queue = new LinkedListQueue<E>(a.length);
        Stream.iterate(0, n -> n + 1).limit(a.length).forEach(i -> queue.enqueue(a[i]));
        return queue;
    }

    public static <E> E josephus(CircularQueue<E> queue, int k) {
        if (queue.isEmpty()) return null;
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) { // skip past k-1 elements
                queue.rotate();
            }
            E e = queue.dequeue(); // remove the front element from the collection
            System.out.println(" " + e + " is out");
        }
        return queue.dequeue();
    }
}
