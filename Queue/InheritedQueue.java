package queue;
import list.LinkedList;

// 연결 리스트 상속
public class InheritedQueue<E> extends LinkedList<E> implements QueueInterface<E> {
	public InheritedQueue() {
		super();
	}
	
	@Override
	public void enqueue(E x) {
		append(x);
	}

	@Override
	public E dequeue() {
		return remove(0);
	}

	@Override
	public E front() {
		return get(0);
	}

	@Override
	public void dequeueAll() {
		clear();
	}

	@Override
	public void print_out() {
		super.print_out();
	}
}
