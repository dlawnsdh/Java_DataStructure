package queue;
import list.Node;

public class LinkedQueue<E> implements QueueInterface<E> {
	private Node<E> tail;
	private Node<E> head; // 더미 헤드
	
	public LinkedQueue() {
		tail = null;
		head = new Node<>(null, tail);
	}
	
	@Override
	public void enqueue(E x) {
		Node<E> newNode = new Node<>(x);
		if (isEmpty()) {
			newNode.setNext(head);
			tail = newNode;
			head.setNext(tail);
			// tail = new Node<>(x, tail); <- 이 코드는 큐가 비어있을 때 tail은 null이므로 
										                 // tail의 다음 노드로 tail을 넣어줬을 때 
			                               // tail을 가리키는게 아닌 null을 가지므로 잘못된 코드이다.
		}
		else {
			newNode.setNext(head);
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	@Override
	public E dequeue() {
		if (isEmpty())
			return null;
		else {
			Node<E> front = tail.getNext();
			if (front == tail) // 원소가 한 개일 때
				tail = null;
			else
				tail.setNext(front.getNext());
			return front.getItem();
		}
	}

	@Override
	public E front() {
		if (isEmpty())
			return null;
		return tail.getNext().getItem();
	}

	@Override
	public boolean isEmpty() {
		return tail == null;
	}

	@Override
	public void dequeueAll() {
		tail = null;
	}
	
	public void copy(LinkedQueue<E> l1, LinkedQueue<E> l2, int n) {
		Node<E> n1 = l1.head.getNext();
		Node<E> n2 = l2.head.getNext();
		for (int i = 0; i < n; i++) {
			E tmp = n1.getItem();
			n2.setItem(tmp);
			n1 = n1.getNext();
			n2 = n2.getNext();
		}
	}

	public void print_out(int n) {
		Node<E> currNode = tail.getNext(); // 더미 헤드
		for (int i = 0; i < n; i++) {
			currNode = currNode.getNext();
			System.out.print(currNode.getItem() + " ");
		}
		System.out.println();
	}
}
