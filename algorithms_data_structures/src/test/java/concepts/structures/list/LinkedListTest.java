package concepts.structures.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LinkedListTest {
    List<String> list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList<>();
    }

    @Test
    public void linkedList_shouldHaveSize0WhenEmpty() throws Exception {
        assertThat(list.size(), equalTo(0));
    }

    @Test
    public void linkedList_shouldHaveAppropriateSizeWhenElementsAdded() {
        list.add("Hello");
        assertThat(list.size(), equalTo(1));

        list.add("Hey there");
        assertThat(list.size(), equalTo(2));
    }
}
