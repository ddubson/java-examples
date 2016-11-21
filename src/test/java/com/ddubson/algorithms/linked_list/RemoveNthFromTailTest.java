package com.ddubson.algorithms.linked_list;

import static com.ddubson.algorithms.linked_list.RemoveNthFromTail.removeNth;
import static org.junit.Assert.assertEquals;

/**
 * Created by ddubs on 10/27/2016.
 */
public class RemoveNthFromTailTest {
    //@Test
    public void removeTest() throws Exception {
        // base case: empty/null list
        assertEquals(null, removeNth(nullList(), 1));

        // list with one element
        ListNode head = oneNodeList();
        assertEquals(1, removeNth(head, 1).val);

        head = twoNodeList();
        ListNode lastRemoved = removeNth(head, 1);
        assertEquals(1, lastRemoved.val);
        System.out.println(head);
        assertEquals(1, removeNth(lastRemoved, 1).val);
        System.out.println(head);

        head = twoNodeList();
        ListNode removed = removeNth(head, 2);
        assertEquals(2, removed.val);
        System.out.println(removed);

    }

    private ListNode oneNodeList() {
        return new LinkedListBuilder().addNode(new ListNode(1)).getList();
    }

    private ListNode twoNodeList() {
        return new LinkedListBuilder()
                .addNode(new ListNode(1))
                .addNode(new ListNode(2)).getList();
    }

    private ListNode nullList() {
        return null;
    }
}