package concepts.structures.deque;

import org.junit.Before;

/**
 * Author: ddubson
 */
public class ArrayDequeTest extends DequeTest {
    @Before
    public void setUp() throws Exception {
        this.deque = new ArrayDeque<Integer>(10);
    }
}
