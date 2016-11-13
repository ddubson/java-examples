package com.ddubson.algorithms.linked_list;

/**
 * Created by ddubs on 10/27/2016.
 */
public class ReverseKGroups {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        if (k < 2 || head.next==null) {
            return head;
        }

        // get size of list (O(n))
        int size = calcSize(head);

        if(k > size) {
            return head;
        }

        // calc number of groups
        int groups = size / k;

        // for each group, perform reverse
        ListNode newHead = null;
        ListNode prevGroupTail = null;
        ListNode nextGroupHead = null;
        ListNode headOfGroup = head;
        ListNode prev = null;
        while (groups != 0) {
            // reverse grouping of k
            int swaps = k;
            prev = null;

            ListNode groupHead = null;
            ListNode groupTail = null;
            ListNode current = headOfGroup;
            while (swaps != 0) {
                ListNode nextUp = null;
                if (swaps == 1) {
                    groupHead = current;
                    nextGroupHead = current.next;
                }

                if (current.next != null) {
                    nextUp = current.next;
                }

                // Identify group tail
                if (swaps == k)
                    groupTail = current;

                // Swap
                current.next = prev;

                prev = current;
                current = nextUp;

                swaps--;
            }
            if (newHead == null) newHead = groupHead;

            if (prevGroupTail != null)
                prevGroupTail.next = groupHead;
            groupTail.next = nextGroupHead;

            prevGroupTail = groupTail;
            headOfGroup = nextGroupHead;

            groups--;
        }

        return newHead;
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
