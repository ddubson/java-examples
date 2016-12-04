package concepts.structures.list;

import concepts.structures.list.node.DNode;

import java.util.NoSuchElementException;

/**
 * Author: ddubson
 */
public class DoublyLinkedList<T> implements CircularlyLinkedList<T> {
    private int size;
    private DNode<T> headSentinel;
    private DNode<T> tailSentinel;

    public DoublyLinkedList() {
        this.size = 0;
        this.headSentinel = new DNode<>();
        this.tailSentinel = new DNode<>();
    }

    @Override
    public void addFirst(T item) {
        DNode<T> node = new DNode<>();
        node.setItem(item);

        if (!headSentinel.hasNext()) {
            createSingleNodeList(node);
        } else {
            DNode<T> toShift = headSentinel.getNext();
            headSentinel.setNext(node);
            node.setPrev(headSentinel);
            node.setNext(toShift);
            toShift.setPrev(node);
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        DNode<T> node = new DNode<>();
        node.setItem(item);

        if (!tailSentinel.hasPrev()) {
            createSingleNodeList(node);
        } else {
            DNode<T> toShift = tailSentinel.getPrev();
            node.setNext(tailSentinel);
            node.setPrev(toShift);
            tailSentinel.setPrev(node);
            toShift.setNext(node);
        }
        size++;
    }

    @Override
    public T first() {
        if (headSentinel.getNext() == null) throw new NoSuchElementException();
        return headSentinel.getNext().getItem();
    }

    @Override
    public T last() {
        if (tailSentinel.getPrev() == null) throw new NoSuchElementException();
        return tailSentinel.getPrev().getItem();
    }

    @Override
    public T removeFirst() {
        if(headSentinel.getNext() == null) return null;

        DNode<T> node = headSentinel.getNext();
        if(node.hasNext()) {
            DNode<T> next = node.getNext();
            headSentinel.setNext(next);
            next.setPrev(headSentinel);
        } else {
            headSentinel.setNext(null);
            tailSentinel.setPrev(null);
        }

        size--;
        return node.getItem();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void rotate() {
        if(isEmpty() || size()==1) return;

        DNode<T> headNode = headSentinel.getNext();
        headSentinel.setNext(headNode.getNext());

        DNode<T> prev = tailSentinel.getPrev();
        prev.setNext(headNode);
        headNode.setPrev(prev);
        headNode.setNext(tailSentinel);
        tailSentinel.setPrev(headNode);
    }

    private void createSingleNodeList(DNode<T> node) {
        headSentinel.setNext(node);
        node.setPrev(headSentinel);
        node.setNext(tailSentinel);
        tailSentinel.setPrev(node);
    }
}
