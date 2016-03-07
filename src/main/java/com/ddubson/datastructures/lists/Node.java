package com.ddubson.datastructures.lists;

/**
 * Created by d.dubson on 2/22/2016.
 */
public class Node<T> {
	T item;
	Node<T> next;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}
