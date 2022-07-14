package stack;
import list.Node; 

public class LinkedStack<E> implements StackInterface<E> {
	private Node<E> topNode;
	private final E ERROR = null;
	
	public LinkedStack() {
		topNode = new Node<>(null, null); // 더미 헤드
	}
	
	@Override
	public void push(E newItem) {
		Node<E> newNode = new Node<>(newItem, topNode.getNext()); 
		topNode.setNext(newNode);
	}

	@Override
	public E pop() {
		if (isEmpty())
			return ERROR;
		E tmp = topNode.getNext().getItem();
		topNode.setNext(topNode.getNext().getNext());
		return tmp;
	}

	@Override
	public E top() {
		if (isEmpty())
			return ERROR;
		return topNode.getNext().getItem();
	}

	@Override
	public boolean isEmpty() {
		return topNode.getNext() == null;
	}

	@Override
	public void popAll() {
		topNode = new Node<>(null, null);
	}

	public void copy(LinkedStack<E> s1, LinkedStack<E> s2) {
		Node<E> n1 = s1.topNode.getNext();
		Node<E> n2 = s2.topNode.getNext();
		while (n1 != null) {
			E tmp = n1.getItem();
			n2.setItem(tmp);
			n1 = n1.getNext();
			n2 = n2.getNext();
		}
	}
	
	public void print_out(int n) {
		Node<E> currNode = topNode.getNext();
		for(int i = 0; i < n; i++) {
			//System.out.print(currNode.getItem());
			System.out.print(currNode.getItem() + " ");
			currNode = currNode.getNext();
		}
		System.out.println();
	}
}
