package stack;
import list.LinkedList;

// Linkedist 상속
public class InheritedStack<E> extends LinkedList<E> implements StackInterface<E> {
	public InheritedStack() {
		super();
	}

	@Override
	public void push(E newItem) {
		add(0, newItem);
	}

	@Override
	public E pop() {
		if (isEmpty())
			return null;
		return remove(0);
	}

	@Override
	public E top() {
		return get(0);
	}

	@Override
	public void popAll() {
		clear();
	}
	
	public void print_out(int n) {
		for(int i = 0; i < n; i++) 
			System.out.print(get(i) + " ");
		System.out.println();
	}
}
