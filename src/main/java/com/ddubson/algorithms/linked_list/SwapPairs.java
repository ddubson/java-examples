package com.ddubson.algorithms.linked_list;

/**
 * Created by ddubs on 10/27/2016.
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        /*
            Given a linked list, swap every two adjacent nodes and return its head.
            Given 1->2->3->4, you should return the list as 2->1->4->3.

            Your algorithm should use only constant space.
            You may not modify the values in the list, only nodes itself can be changed.
        */

        // base case: empty list -> return null
        if(head==null) {
            return null;
        }

        if(head.next == null) {
            return head;
        }

        // list of size 2
        ListNode savedHead = null;
        ListNode prev = null;
        while(head != null && head.next != null) {
            // swap head with head.next
            ListNode temp = null;
            if(head.next.next != null) {
                temp = head.next.next;
            }

            ListNode second = head.next;
            ListNode first = head;
            second.next = first;
            first.next = temp;
            if(prev != null) {
                prev.next = second;
            }

            // Set up for next loop
            prev = first;
            head = temp;

            if(savedHead == null) {
                savedHead = second;
            }
        }

        return savedHead;
    }

    private class ListNode {
        public ListNode next;
    }
}
