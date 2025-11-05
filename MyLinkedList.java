import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size = 0;

    public boolean add(E element) {
        ListNode<E> newNode = new ListNode<>(element);
        if (head == null)
            head = tail = newNode;
        else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;

        return true
    }

    public boolean addFirst(E element) {
        ListNode<E> newNode = new ListNode<>(element);

        head.setPrev(newNode);
        newNode.setNext(head);

        size++;

        return true;
    }

    public boolean addLast(E element) {
        return add(element);
    }

    public E set(int index, E element) {
        checkElementIndex(index);
        ListNode<E> node = getNode(index);
        E prevData = node.getData();
        node.setData(element);
        return prevData;
    }

    public E get(int index) {
        checkElementIndex(index);
        return getNode(index).getData();
    }

    public E remove(int index) {
        checkElementIndex(index);
        ListNode<E> node = getNode(index);

        ListNode<E> prev = node.getPrev();
        ListNode<E> next = node.getNext();

        if (prev != null) 
            prev.setNext(next);
        else head = next;

        if (next != null) 
            next.setPrev(prev);
        else tail = prev;

        size--;
        return node.getData();
    }

    public E removeFirst() {
        ListNode<E> nextNode = head.getNext();
        head.setNext(null);
        head.setPrev(null);
        head = nextNode;

        return head.getData();
    }

    public E removeLast() {
        ListNode<E> prevNode = tail.getPrev();
        tail.setPrev(null);
        tail.setNext(null);
        tail = prevNode;

        return tail.getData();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListNode<E> current = head;
        while (current != null) {
            sb.append(current.getData());
            current = current.getNext();
            if (current != null) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Helper methods
    private ListNode<E> getNode(int index) {
        checkElementIndex(index);
        ListNode<E> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++)
                current = current.getNext();
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--)
                current = current.getPrev();
        }
        return current;
    }

    private void checkElementIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
}