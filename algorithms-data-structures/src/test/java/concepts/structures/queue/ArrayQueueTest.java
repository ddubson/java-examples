package concepts.structures.queue;

import org.junit.Before;

/**
 * Author: ddubson
 */
public class ArrayQueueTest extends AbstractQueueTest {
    @Before
    public void setUp() throws Exception {
        this.queue = new ArrayQueue<>(getCapacity());
    }

    @Override
    int getCapacity() {
        return 10;
    }
}