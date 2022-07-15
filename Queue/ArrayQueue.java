package queue;

public class ArrayQueue<E> implements QueueInterface<E> {
	private E[] queue;
	private int numItems, front, tail; // 원형 큐
	private static final int DEFAULT_CAPACITY = 64;
	
	public ArrayQueue() {
		numItems = 0; front = 0; tail = DEFAULT_CAPACITY - 1;
		queue = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public ArrayQueue(int n) {
		numItems = 0; front = 0; tail = n - 1;
		queue = (E[]) new Object[n];
	}
	
	@Override
	public void enqueue(E x) {
		if (numItems == queue.length) {
			E[] bigger = (E[]) new Object[queue.length * 2];
			System.arraycopy(queue, 0, bigger, 0, numItems);
			queue = bigger;
		} 
		tail = (tail + 1) % queue.length; // 원형 큐 이므로 n - 1 -> 0번째 인덱스로
		queue[tail] = x; 
		numItems++;
	}
	@Override
	public E dequeue() {
		if (isEmpty())
			return null;
		E tmp = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length; // 원형 큐 이므로 n - 1 -> 0번째 인덱스로
		numItems--;
		return tmp;
	}
	@Override
	public E front() {
		if (isEmpty())
			return null;
		return queue[front];
	}
	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}
	@Override
	public void dequeueAll() {
		numItems = 0; front = 0; tail = queue.length - 1;
		queue = (E[]) new Object[queue.length];
	}
	
	public void print_out() {
		for (int i = front; i <= tail; i++) 
			System.out.print(queue[i] + " ");
		System.out.println();
	}
}
