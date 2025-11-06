/*
    Name: Nick Griffith
    Period: 6
    Date: 11/6/25
    Description: Nodes placed in MyLinkedList, hold a data value and the node before and in front of them/
*/

public class ListNode<E> {
	private E value;
	private ListNode next = null;
	private ListNode prev = null;

	public ListNode(E value) {
		data = value;
	} // end constructor
	
	public ListNode(E value, ListNode initNext) {
		data = value;
		next = initNext;
	} // end constructor

	public E getData() {
		return value;
	} // end getData

	public ListNode getNext() {
		return next;
	} // end getNext

	public ListNode getPrev() {
		return prev;
	} // end getPrev

	public void setValue(E newData) {
		value = newData;
	} // end setValue

	public void setNext(ListNode newNext) {
		next = newNext;
	} // end setNext

	public void setPrev(ListNode newPrev) {
		prev = newPrev;
	} // end setPrev
} // end class
