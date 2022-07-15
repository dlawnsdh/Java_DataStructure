package queue;
import list.BidirectionalNode;

public class DoublyLinkedQueue<E> implements QueueInterface<E> {
	private BidirectionalNode<E> head; // 더미 헤드
	
	public DoublyLinkedQueue() {
		head = new BidirectionalNode<>(null);
		head.setPrev(head);
		head.setNext(head);
	}

	@Override
	public void enqueue(E x) {
		BidirectionalNode<E> newNode = new BidirectionalNode<>(x);
		if (isEmpty()) {
			newNode.setNext(head);
			newNode.setPrev(head);
			head.setNext(newNode);
			head.setPrev(newNode);
		}
		else {
			newNode.setNext(head);
			newNode.setPrev(head.getPrev());
			head.getPrev().setNext(newNode);
			head.setPrev(newNode);
		}
	}

	@Override
	public E dequeue() {
		if (isEmpty())
			return null;
		BidirectionalNode<E> currNode = head.getNext();
		head.setNext(currNode.getNext());
		currNode.getNext().setPrev(head);
		return currNode.getItem();
	}

	@Override
	public E front() {
		if (isEmpty())
			return null;
		return head.getNext().getItem();
	}

	@Override
	public boolean isEmpty() {
		return head.getNext() == head;
	}

	@Override
	public void dequeueAll() {
		head = new BidirectionalNode<>(null);
		head.setPrev(head);
		head.setNext(head);
	}
	
	public void print_out(int n) {
		BidirectionalNode<E> currNode = head.getNext();
		for (int i = 0; i < n; i++) {
			System.out.print(currNode.getItem() + " ");
			currNode = currNode.getNext();
		}
		System.out.println();
	}
}
