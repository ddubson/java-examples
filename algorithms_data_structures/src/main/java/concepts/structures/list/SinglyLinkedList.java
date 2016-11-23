package concepts.structures.list;

public class SinglyLinkedList<T> implements LinkedList<T> {
    Node<T> head = null;
    Node<T> tail = null;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    @Override
    public void addFirst(T item) {
        // add to head
        Node<T> toAdd = new Node<>();
        toAdd.setItem(item);
        toAdd.setNext(head);

        head = toAdd;
        if(tail == null) {
            tail = head;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        // add to tail
        Node<T> toAdd = new Node<>();
        toAdd.setItem(item);
        toAdd.setNext(null);
        if (tail != null)
            tail.setNext(toAdd);
        else {
            head = toAdd;
        }

        tail = toAdd;
        size++;
    }

    @Override
    public T first() {
        return this.head.getItem();
    }

    @Override
    public T last() {
        return this.tail.getItem();
    }

    @Override
    public T removeFirst() {
        if(head==null) return null;

        T toRemove = head.getItem();
        head = head.getNext();
        size--;
        return toRemove;
    }

    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
