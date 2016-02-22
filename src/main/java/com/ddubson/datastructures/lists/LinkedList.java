package com.ddubson.datastructures.lists;

public class LinkedList<T> implements List<T> {
	private int size;
	Node<T> firstNode;

	public LinkedList() {
		this.size = 0;
	}

	public void add(T item) {
		Node<T> n = new Node<>();
		n.setItem(item);

		if(size < 1) {
			n.setNext(null);
			firstNode = n;
		} else {

		}

		size++;
	}

	public int size() {
		return this.size;
	}
}
