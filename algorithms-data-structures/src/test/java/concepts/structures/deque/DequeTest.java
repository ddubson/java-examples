package concepts.structures.deque;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * Author: ddubson
 */
public abstract class DequeTest {
    protected Deque<Integer> deque;

    @Test
    public void deque_shouldReturnSize0WhenEmpty() throws Exception {
        assertThat(deque.size(), is(0));
    }

    @Test
    public void deque_shouldReturnTrueWhenEmpty() throws Exception {
        assertThat(deque.isEmpty(), is(true));
    }

    @Test
    public void deque_shouldReturnFalseWhenNonEmpty() throws Exception {
        deque.addFirst(1);
        assertThat(deque.isEmpty(), is(false));
    }

    @Test
    public void deque_shouldReturnCorrectSizeOnNonEmptyDeque() throws Exception {
        deque.addFirst(1);
        deque.addFirst(2);
        assertThat(deque.size(), is(2));
    }

    @Test
    public void deque_shouldReturnFirstElement() throws Exception {
        deque.addFirst(1);
        assertThat(deque.first(), is(1));
    }

    @Test
    public void deque_shouldReturnLastElementOnASingleElementDeque() throws Exception {
        deque.addFirst(1);
        assertThat(deque.first(), is(1));
        assertThat(deque.last(), is(1));
    }

    @Test
    public void deque_shouldReturnFirstElementOnASingleElementDeque() throws Exception {
        deque.addLast(1);
        assertThat(deque.first(), is(1));
        assertThat(deque.last(), is(1));
    }

    @Test
    public void deque_shouldReturnFirstAndLastValuesCorrectly() throws Exception {
        deque.addFirst(2);
        deque.addLast(1);
        assertThat(deque.first(), is(2));
        assertThat(deque.last(), is(1));
        assertThat(deque.size(), is(2));
    }

    @Test
    public void deque_shouldAddMultipleFirsts() throws Exception {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertThat(deque.last(), is(1));
        assertThat(deque.first(), is(3));
        assertThat(deque.size(), is(3));
    }

    @Test
    public void deque_shouldRemoveFirstSuccessfully() throws Exception {
        deque.addFirst(1);
        deque.addFirst(2);
        assertThat(deque.size(), is(2));
        assertThat(deque.first(), is(2));
        assertThat(deque.last(), is(1));
        int i = deque.removeFirst();
        assertThat(i, is(2));
        assertThat(deque.size(), is(1));
        assertThat(deque.first(), is(1));
        assertThat(deque.last(), is(1));
    }

    @Test
    public void deque_shouldRemoveLastSuccessfully() throws Exception {
        deque.addFirst(1);
        deque.addFirst(2);
        assertThat(deque.size(), is(2));
        assertThat(deque.first(), is(2));
        assertThat(deque.last(), is(1));
        int i = deque.removeLast();
        assertThat(i, is(1));
        assertThat(deque.size(), is(1));
        assertThat(deque.first(), is(2));
        assertThat(deque.last(), is(2));
    }

    @Test
    public void deque_removeFirstWhenEmptyShouldReturnNull() throws Exception {
        assertNull(deque.removeFirst());
    }

    @Test
    public void deque_removeLastWhenEmptyShouldReturnNull() throws Exception {
        assertNull(deque.removeLast());
    }

    @Test
    public void deque_addFirstAndRemoveLastShouldExecuteSuccessfully() throws Exception {
        deque.addFirst(1);
        int i = deque.removeLast();
        assertThat(i, is(1));
        assertThat(deque.isEmpty(), is(true));
    }

    @Test
    public void deque_generalTest() throws Exception {
        deque.addLast(5);
        assertThat(deque.size(), is(1));

        deque.addFirst(3);
        assertThat(deque.first(), is(3));
        assertThat(deque.last(), is(5));

        deque.addFirst(7);
        assertThat(deque.first(), is(7));
        assertThat(deque.last(), is(5));

        assertThat(deque.removeLast(), is(5));
        assertThat(deque.size(), is(2));
        assertThat(deque.removeLast(), is(3));
        assertThat(deque.removeFirst(), is(7));

        deque.addFirst(6);
        assertThat(deque.last(), is(6));
        deque.addFirst(8);
        assertThat(deque.isEmpty(), is(false));
        assertThat(deque.last(), is(6));
    }
}