package concepts.structures.queue;

/**
 * Author: ddubson
 *
 * Useful for:
 *      - multi-player, turn-based games,
 *      - round-robin scheduling
 */
public interface CircularQueue<E> extends Queue<E> {
    void rotate();
}
