/*
    Name: Nick Griffith
    Period: 6
    Date: 11/6/25
    Description: A recreation of the native LinkedList class.
*/

import java.util.IndexOutOfBoundsException;

public class MyLinkedList<E> {
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size = 0;

    // no constructor needed (implicit)

    public boolean add(E element) {
        ListNode<E> newNode = new ListNode<>(element);
        if (head == null)
            head = tail = newNode;
        else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        } // end else

        size++;

        return true;
    } // end method

    public boolean addFirst(E element) {
        ListNode<E> newNode = new ListNode<>(element);

        head.setPrev(newNode);
        newNode.setNext(head);

        size++;

        return true;
    } // end method

    public boolean addLast(E element) {
        return add(element);
    } // end method

    public E set(int index, E element) {
        checkElementIndex(index);
        ListNode<E> node = getNode(index);
        E prevData = node.getData();
        node.setData(element);
        return prevData;
    } // end method

    public E get(int index) {
        checkElementIndex(index);
        return getNode(index).getData();
    } // end method

    public E remove(int index) {
        checkElementIndex(index);
        return removeNode(getNode(index));
    } // end method

    // Precondition: List has at least one element.
    public E removeFirst() {
        return removeNode(head);
    } // end methdo

    // Precondition: List has at least one element.
    public E removeLast() {
       return removeNode(tail);
    } // end method

    public int size() {
        return size;
    } // end getter

    public boolean isEmpty() {
        return size == 0;
    } // end getter

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListNode<E> current = head;
        while (current != null) {
            sb.append(current.getData());
            current = current.getNext();
            if (current != null) sb.append(", ");
        } // end while
        sb.append("]");
        return sb.toString();
    } // end method

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
        } // end if/else
        return current;
    } // end method

    private E removeNode(ListNode<E> node) {
        ListNode<E> prev = node.getPrev();
        ListNode<E> next = node.getNext();

        if(prev != null)
            prev.setNext(next);
        else head = next;

        if(next != null)
            next.setPrev(prev);
        else tail = prev;

        // redudant
        node.setPrev(null);
        node.setNext(null);

        size--;

        return node.getData();
    } // end helper method

    private void checkElementIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    } // end helper method
} // end class