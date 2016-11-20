package com.ddubson.algorithms.linked_list;

/**
 * Created by ddubs on 10/27/2016.
 */
public class RemoveNthFromTail {
    public static ListNode removeNth(ListNode head, int n) {
        if(head == null) return null;

        int size = calcSize(head);

        if(n > size) {
            return null;
        }

        ListNode savedHead = head;
        if(head.next == null) {
            return null;
        }

        int ceil = size - n;

        if(ceil == 0) {
            savedHead = head.next;
        }

        for (int i = 1; i < ceil; i++) {
            head = head.next;
        }

        ListNode prev = head;
        ListNode toRemove = prev.next;

        ListNode ahead = null;
        if (toRemove.next != null) {
            ahead = toRemove.next;
        }

        if(ahead != null) {
            prev.next = ahead;
        } else {
            prev.next = null;
        }

        return savedHead;
    }

    private static int calcSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
