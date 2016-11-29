package concepts.structures.list;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public abstract class AbstractLinkedListTest {
    protected CircularlyLinkedList<String> list;

    @Test
    public void linkedList_shouldHaveSize0WhenEmpty() throws Exception {
        assertThat(list.size(), equalTo(0));
    }

    @Test
    public void linkedList_shouldHaveAppropriateSizeWhenAddedToHead() {
        list.addFirst("Hello");
        assertThat(list.size(), equalTo(1));
        assertFalse(list.isEmpty());

        list.addFirst("Hey there");
        assertThat(list.size(), equalTo(2));
    }

    @Test
    public void linkedList_shouldHaveAppropriateSizeWhenAddedToTail() throws Exception {
        list.addLast("Hey");
        assertThat(list.size(), equalTo(1));
        assertThat(list.first(), equalTo(list.last()));

        list.addLast("You");
        assertThat(list.size(), equalTo(2));
        assertThat(list.first(), equalTo("Hey"));
        assertThat(list.last(), equalTo("You"));
        assertFalse(list.isEmpty());
    }

    @Test
    public void linkedList_shouldHaveAppropriateSizeWhenFirstAndLastAdded() throws Exception {
        list.addFirst("Hello");
        list.addLast("You");
        assertTrue(list.size()==2);
        assertThat(list.first(), equalTo("Hello"));
        assertThat(list.last(), equalTo("You"));
        list.addFirst("How");
        list.addLast("There");
        assertTrue(list.size()==4);
        assertThat(list.first(), equalTo("How"));
        assertThat(list.last(), equalTo("There"));
        String s = list.removeFirst();
        assertThat(s, equalTo("How"));
        assertThat(list.size(), equalTo(3));
        assertThat(list.first(), equalTo("Hello"));

    }

    @Test
    public void linkedList_shouldThrowExceptionIfNothingToRemove() throws Exception {
        assertNull(list.removeFirst());
    }

    @Test
    public void linkedList_shouldRemoveItemFromList() throws Exception {
        list.addFirst("Hello");
        assertThat(list.removeFirst(), equalTo("Hello"));
        assertTrue(list.size()==0);
    }

    @Test
    public void linkedList_emptyListRotatedShouldDoNothing() throws Exception {
        list.rotate();
        assertThat(list.size(), equalTo(0));
    }

    @Test
    public void linkedList_singleElementListRotatedShouldDoNothing() throws Exception {
        list.addLast("Hey");
        list.rotate();
        assertThat(list.first(), equalTo("Hey"));
        assertThat(list.size(), equalTo(1));
    }

    @Test
    public void linkedList_multipleElementListRotatedShouldBeDoneCorrectly() throws Exception {
        list.addFirst("Hey");
        list.addLast("You");
        list.rotate(); // You, Hey
        assertThat(list.first(), equalTo("You"));
        assertThat(list.last(), equalTo("Hey"));
        list.rotate(); // Hey, You
        assertThat(list.first(), equalTo("Hey"));
        assertThat(list.last(), equalTo("You"));
        list.addLast("Again"); // Hey, You, Again
        list.rotate(); // You, Again, Hey
        assertThat(list.first(), equalTo("You"));
        assertThat(list.last(), equalTo("Hey"));
        list.rotate(); // Again, Hey, You
        assertThat(list.first(), equalTo("Again"));
        assertThat(list.last(), equalTo("You"));
    }
}
