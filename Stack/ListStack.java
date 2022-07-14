package stack;
import list.LinkedList;
import list.ListInterface;

// 리스트 인터페이스 사용
public class ListStack<E> implements StackInterface<E> {
	private ListInterface<E> list;
	
	public ListStack() {
		list = new LinkedList<E>();
	}
	
	@Override
	public void push(E newItem) {
		//list.add(0, newItem); // 리스트의 맨 앞이 스택의 탑
		list.append(newItem);   //리스트의 맨 뒤가 스택의 탑
	}

	@Override
	public E pop() {
		if (list.isEmpty())
			return null;
		//return list.remove(0);
		return list.remove(list.len() - 1);
	}

	@Override
	public E top() {
		//return list.get(0);
		return list.get(list.len() - 1);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void popAll() {
		list.clear();
	}

	public void print_out(int n) {
		for(int i = 0; i < n; i++)
			System.out.printf(list.get(i) + " ");
		System.out.println();
	}
}
