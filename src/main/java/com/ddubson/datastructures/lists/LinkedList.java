package com.ddubson.datastructures.lists;

public class LinkedList<T> implements List<T> {
	private int size;
	Node<T> firstNode;
	Node<T> lastNode;

	public LinkedList() {
		this.size = 0;
	}

	public void add(T item) {
		Node<T> n = new Node<>();
		n.setItem(item);

		// If the size of the linked list is 0, then set the new node as the first node
		// and set next in the node as null
		if(size < 1) {
			n.setNext(null);
			firstNode = n;
			lastNode = firstNode;
		}

		size++;
	}

	public T get(int index) {
		return null;
	}

	public int size() {
		return this.size;
	}
}
