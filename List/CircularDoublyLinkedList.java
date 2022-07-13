import java.lang.*;
import list.BidirectionalNode;
import list.ListInterface;

public class CircularDoublyLinkedList<E> implements ListInterface<E> {
	private BidirectionalNode<E> head;
	private int numItems;
	
	public CircularDoublyLinkedList() {
		numItems = 0;
		head = new BidirectionalNode<>(null);
		head.setPrev(head);
		head.setNext(head);
	}

	@Override
	public void add(int i, E x) {
		if (i >= 0 && i <= numItems) { // 맨 뒤에 삽입 뒬 경우 numItems와 i 값이 같다.
			BidirectionalNode<E> prevNode = getNode(i - 1);
			BidirectionalNode<E> newNode = new BidirectionalNode<>(x, prevNode, prevNode.getNext());
			prevNode.setNext(newNode);
			newNode.getNext().setPrev(newNode);
			numItems++;
		}
	}
	
	@Override
	public void append(E x) {
		BidirectionalNode<E> prevNode = head.getPrev();
		BidirectionalNode<E> newNode = new BidirectionalNode<>(x, prevNode, head);
		head.setPrev(newNode);
		prevNode.setNext(newNode);
		numItems++;
	}

	@Override
	public E remove(int i) {
		if (i >= 0 && i < numItems) {
			BidirectionalNode<E> currNode = getNode(i);
			currNode.getPrev().setNext(currNode.getNext());
			currNode.getNext().setPrev(currNode.getPrev());
			numItems--;
			return currNode.getItem();
		}
		return null;
	}

	@Override
	public boolean removeItem(E x) {
		BidirectionalNode<E> currNode = head;
		for (int i = 0; i < numItems; i++) {
			currNode = currNode.getNext();
			if (((Comparable)currNode.getItem()).compareTo(x) == 0) {
				currNode.getPrev().setNext(currNode.getNext());
				currNode.getNext().setPrev(currNode.getPrev());
				numItems--;
				return true;
			}
		}
		return false;
	}

	@Override
	public E get(int i) {
		if (i >= 0) //더미 헤드는 -1
			return getNode(i).getItem();
		return null;
	}

	public BidirectionalNode<E> getNode(int i) {
		if (i >= -1 && i < numItems) {
			BidirectionalNode<E> currNode = head;
			if (i < numItems / 2) 
				for (int k = 0; k <= i; k++)
					currNode = currNode.getNext();
			else 
				for (int k = numItems - 1; k >= i; k--)
					currNode = currNode.getPrev();
			return currNode;
		}
		return null;
	}

	@Override
	public void set(int i, E x) {
		if (i >= 0)
			getNode(i).setItem(x);
	}

	private final int NOT_FOUND = -12345;
	@Override
	public int indexOf(E x) {
		BidirectionalNode<E> currNode = head;
		for (int i = 0; i < numItems; i++) {
			currNode = currNode.getNext();
			if (((Comparable)currNode.getItem()).compareTo(x) == 0) {
				return i;
			}
		}
		return NOT_FOUND;
	}

	@Override
	public int len() {
		return numItems;
	}

	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}

	@Override
	public void clear() {
		numItems = 0;
		head = new BidirectionalNode<>(null);
		head.setPrev(head);
		head.setNext(head);
	}
	
	public void print_out() {
		BidirectionalNode<E> currNode = head;
		for(int i = 0; i < numItems; i++) {
			currNode = currNode.getNext();
			System.out.print(currNode.getItem() + " ");
		}
		System.out.println();
	}
}
