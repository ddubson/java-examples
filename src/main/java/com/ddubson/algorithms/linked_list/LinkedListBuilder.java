package com.ddubson.algorithms.linked_list;

/**
 * Created by ddubs on 10/27/2016.
 */
public class LinkedListBuilder {
    ListNode head;
    ListNode tail;

    public LinkedListBuilder() {
        head = null;
        tail = null;
    }

    public LinkedListBuilder addNode(ListNode node) {
        if(head == null) head = node;
        if(tail == null) tail = node;
        else {
            tail.next = node;
        }
        tail = node;
        return this;
    }

    public ListNode getList() {
        return this.head;
    }
}
