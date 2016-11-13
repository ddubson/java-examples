package com.ddubson.algorithms.linked_list;

import org.junit.Test;

import static com.ddubson.algorithms.linked_list.ReverseKGroups.reverseKGroup;
import static org.junit.Assert.*;

/**
 * Created by ddubs on 10/27/2016.
 */
public class ReverseKGroupsTest {
    @Test
    public void kgroupsReverse() throws Exception {
        assertEquals(null, reverseKGroup(nullList(), 1));

        ListNode head = oneNodeList();
        assertEquals(head, reverseKGroup(head, 1));

        // Swap in 1-Group : no change
        head = twoNodeList();
        assertEquals(head, reverseKGroup(head, 1));
        System.out.println(head);

        // Swap a 2 node list in 2-Group
        ListNode exHead = reverseKGroup(head, 2);
        assertEquals(2, exHead.val);
        System.out.println(exHead);

        // Swap a 3 node list in 2-Group pairs
        head = threeNodeList();
        exHead = reverseKGroup(head, 2);
        assertEquals(2, exHead.val);
        System.out.println(exHead);

        // Swap a 4 node list in 2-Group pairs
        head = fourNodeList();
        exHead = reverseKGroup(head, 2);
        assertEquals(2, exHead.val);
        System.out.println(exHead);

        head = fiveNodeList();
        exHead = reverseKGroup(head, 2);
        assertEquals(2, exHead.val);
        System.out.println(exHead);

        head = fiveNodeList();
        exHead = reverseKGroup(head, 3);
        assertEquals(3, exHead.val);
        System.out.println(exHead);
    }

    private ListNode nullList() {
        return null;
    }

    private ListNode oneNodeList() {
        return new LinkedListBuilder().addNode(new ListNode(1)).getList();
    }

    private ListNode twoNodeList() {
        return new LinkedListBuilder().addNode(new ListNode(1))
                .addNode(new ListNode(2)).getList();
    }

    private ListNode threeNodeList() {
        return new LinkedListBuilder().addNode(new ListNode(1))
                .addNode(new ListNode(2)).addNode(new ListNode(3)).getList();
    }

    private ListNode fourNodeList() {
        return new LinkedListBuilder()
                .addNode(new ListNode(1))
                .addNode(new ListNode(2))
                .addNode(new ListNode(3))
                .addNode(new ListNode(4)).getList();
    }

    private ListNode fiveNodeList() {
        return new LinkedListBuilder()
                .addNode(new ListNode(1))
                .addNode(new ListNode(2))
                .addNode(new ListNode(3))
                .addNode(new ListNode(4))
                .addNode(new ListNode(5)).getList();
    }
}