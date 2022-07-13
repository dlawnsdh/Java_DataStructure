import java.lang.*;
import list.ListInterface;
import list.Node;

public class CircularLinkedList<E> implements ListInterface<E> {
	private Node<E> tail; 
	private int numItems;
	
	public CircularLinkedList() {
		tail = new Node(-1);
		tail.setNext(tail);
		numItems = 0;
	}

	@Override
	public void add(int i, E x) {
		if (i >= 0 && i <= numItems) { // 맨 뒤에 삽입 뒬 경우 numItems와 i 값이 같다.
			Node<E> preNode = getNode(i - 1);
			Node<E> newNode = new Node<>(x, preNode.getNext());
			preNode.setNext(newNode);
			if (i == numItems) // 맨 끝에 삽입
				tail = newNode;
			numItems++;
		}
	}

	@Override
	public void append(E x) {
		Node<E> preNode = tail;
		Node<E> newNode =  new Node<>(x, tail.getNext());
		preNode.setNext(newNode);
		tail = newNode;
		numItems++;
	}

	@Override
	public E remove(int i) {
		if (i >= 0 && i < numItems) { 
			Node<E> preNode = getNode(i - 1);
			Node<E> currNode = preNode.getNext();
			preNode.setNext(currNode.getNext());
			if (i == numItems - 1)
				tail = preNode;
			numItems--;
			return currNode.getItem();
		}
		return null;
	}

	@Override
	public boolean removeItem(E x) {
		Node<E> currNode = tail.getNext(); //더미 헤드 (원형 연결 리스트이므로 tail노드의 다음 노드는 더미 헤드이다)
		for (int i = 0; i < numItems; i++) {
			currNode = currNode.getNext();
			E tmp = currNode.getItem();
			if (((Comparable)tmp).compareTo(x) == 0) {
				Node<E> preNode = getNode(i - 1);
				preNode.setNext(currNode.getNext());
				numItems--;
				return true;
			}
		}
		return false;
	}

	@Override
	public E get(int i) {
		if (i >= 0)
			return getNode(i).getItem();
		return null;
	}

	public Node<E> getNode(int i) {
		if (i >= -1 && i < numItems) {
			Node<E> currNode = tail.getNext(); //더미 헤드
			for (int k = 0; k <= i; k++) 
				currNode = currNode.getNext();
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
		Node<E> currNode = tail.getNext();
		for (int i = 0; i < numItems; i++) {
			currNode = currNode.getNext();
			E tmp = currNode.getItem();
			if (((Comparable)tmp).compareTo(x) == 0)
				return i;
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
		tail = new Node(-1);
		tail.setNext(tail);
	}
	
	public void print_out() {
		Node<E> currNode = tail.getNext(); //더미 헤드
		for(int i = 0; i < numItems; i++) {
			currNode = currNode.getNext();
			System.out.print(currNode.getItem() + " ");
		}
		System.out.println();
	}
}
