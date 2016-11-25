package concepts.structures.list.node;

/**
 * Created by d.dubson on 2/22/2016.
 */
public class Node<T> {
	private T item;
	private Node<T> next;

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
