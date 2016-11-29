package concepts.structures.queue;

import org.junit.Before;

/**
 * Author: ddubson
 */
public class LinkedListQueueTest extends AbstractQueueTest{
    @Before
    public void setUp() throws Exception {
        this.queue = new LinkedListQueue<>(getCapacity());
    }

    @Override
    int getCapacity() {
        return 10;
    }
}