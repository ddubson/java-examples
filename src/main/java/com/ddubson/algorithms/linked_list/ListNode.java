package com.ddubson.algorithms.linked_list;

/**
 * Created by ddubs on 10/27/2016.
 */
public class ListNode {
    public ListNode next;
    public final int val;

    public ListNode(int val) {
        this.val = val;
    }

    public String toString() {
        return this.val + (next != null ? "->" + this.next : "");
    }
}
