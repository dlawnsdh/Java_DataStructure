package queue;
import list.LinkedList;
import list.ListInterface;

// 리스트 인터페이스 사용
public class ListQueue<E> implements QueueInterface<E> {
	private ListInterface<E> list;
	
	public ListQueue() {
		list = new LinkedList<>();
	}
	
	@Override
	public void enqueue(E x) {
		//list.append(x); // 리스트의 맨 앞이 front 맨 뒤가 tail
		list.add(0, x);   // 리스트의 맨 앞이 tail 맨 뒤가 front
		
	}

	@Override
	public E dequeue() {
		//return list.remove(0);            // 리스트의 맨 앞이 front 맨 뒤가 tail
		return list.remove(list.len() - 1); // 리스트의 맨 앞이 tail 맨 뒤가 front
	}

	@Override
	public E front() {
		//return list.get(0);            // 리스트의 맨 앞이 front 맨 뒤가 tail
		return list.get(list.len() - 1); // 리스트의 맨 앞이 tail 맨 뒤가 front
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void dequeueAll() {
		list.clear();
	}

	public void print_out_front() {
		for (int i = 0; i < list.len(); i++) 
			System.out.print(list.get(i) + " ");
		System.out.println();
	}
	
	public void print_out_tail() {
		for (int i = list.len() - 1; i >= 0; i--) 
			System.out.print(list.get(i) + " ");
		System.out.println();
	}
}
