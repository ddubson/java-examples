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

        ReverseKGroups.ListNode head = oneNodeList();
        assertEquals(head, reverseKGroup(head, 1));

        // Swap in 1-Group : no change
        head = twoNodeList();
        assertEquals(head, reverseKGroup(head, 1));
        System.out.println(head);

        // Swap a 2 node list in 2-Group
        ReverseKGroups.ListNode exHead = reverseKGroup(head, 2);
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

        //ssertEquals()
    }

    private ReverseKGroups.ListNode nullList() {
        return null;
    }

    private ReverseKGroups.ListNode oneNodeList() {
        return new ReverseKGroups.ListNode(1);
    }

    private ReverseKGroups.ListNode twoNodeList() {
        ReverseKGroups.ListNode node1 = new ReverseKGroups.ListNode(1);
        ReverseKGroups.ListNode node2 = new ReverseKGroups.ListNode(2);
        node1.next = node2;
        return node1;
    }

    private ReverseKGroups.ListNode threeNodeList() {
        ReverseKGroups.ListNode node1 = new ReverseKGroups.ListNode(1);
        ReverseKGroups.ListNode node2 = new ReverseKGroups.ListNode(2);
        ReverseKGroups.ListNode node3 = new ReverseKGroups.ListNode(3);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }

    private ReverseKGroups.ListNode fourNodeList() {
        ReverseKGroups.ListNode node1 = new ReverseKGroups.ListNode(1);
        ReverseKGroups.ListNode node2 = new ReverseKGroups.ListNode(2);
        ReverseKGroups.ListNode node3 = new ReverseKGroups.ListNode(3);
        ReverseKGroups.ListNode node4 = new ReverseKGroups.ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }

    private ReverseKGroups.ListNode fiveNodeList() {
        ReverseKGroups.ListNode node1 = new ReverseKGroups.ListNode(1);
        ReverseKGroups.ListNode node2 = new ReverseKGroups.ListNode(2);
        ReverseKGroups.ListNode node3 = new ReverseKGroups.ListNode(3);
        ReverseKGroups.ListNode node4 = new ReverseKGroups.ListNode(4);
        ReverseKGroups.ListNode node5 = new ReverseKGroups.ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }
}