package com.ddubson.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: ddubson
 */
public class LRUCache {
    private final int capacity;
    Map<Integer, DLinkedNode> data;
    DLinkedNode head = null, tail = null;

    public LRUCache(int capacity) {
        this.data = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!data.containsKey(key)) {
            return -1;
        } else {
            moveNodeToTail(key);
            return data.get(key).value;
        }
    }

    public void set(int key, int value) {
        boolean exists = data.containsKey(key);
        if (!exists && exceedingCapacity()) {
            popHead();
        }

        if (exists) {
            moveNodeToTail(key);
            DLinkedNode node = data.get(key);
            node.value = value;
        } else {
            DLinkedNode node = new DLinkedNode();
            node.key = key;
            node.value = value;

            if (head == null) {
                head = node;
            } else {
                node.next = tail;
                if (tail != null) {
                    tail.prev = node;
                }
                node.prev = null;
            }

            data.put(key, node);
            tail = node;
        }
    }

    public boolean exceedingCapacity() {
        return this.data.keySet().size() >= capacity;
    }

    public void moveNodeToTail(int key) {
        // if one node in list
        DLinkedNode node = data.get(key);
        if (node == tail) return;

        if (node.next == null && node.prev == null) {
            return;
        }

        // if node is head
        if (head == node) {
            // make head the prev
            head = node.prev;
        }

        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        if (next != null) {
            next.prev = prev;
            head = next;
        }

        // make node the tail
        node.next = tail;
        if (tail != null) tail.prev = node;
        node.prev = null;
        tail = node;
    }

    public void popHead() {
        DLinkedNode head = this.head;
        data.remove(head.key);
        if (head.prev != null) {
            this.head = head.prev;
            this.head.next = null;
        } else
            this.head = null;
    }

    class DLinkedNode {
        public DLinkedNode prev = null;
        public DLinkedNode next = null;
        public int key;
        public int value;
    }

}

