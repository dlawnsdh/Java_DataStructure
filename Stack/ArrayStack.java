package stack;

public class ArrayStack<E> implements StackInterface<E> {
	private E[] stack;
	private int topIndex;
	private static final int DEFAULT_CAPACITY = 64;
	private final E ERROR = null;
	
	public ArrayStack() {
		topIndex = -1; 
		stack = (E[]) new Object[DEFAULT_CAPACITY]; // 모든 클래스의 상위인 Object로 배열 생성 후 제네릭으로 형변환
	}
	
	public ArrayStack(int n) {
		topIndex = -1;
		stack = (E[]) new Object[n];
	}
	
	@Override
	public void push(E newItem) {
		if (isFull()) {
			E[] bigger = (E[]) new Object[stack.length * 2];
			System.arraycopy(stack, 0, bigger, 0, stack.length);
			stack = bigger;
		}
		else
			stack[++topIndex] = newItem;
	}

	@Override
	public E pop() {
		if (isEmpty())
			return ERROR;
		return stack[topIndex--];
	}

	@Override
	public E top() {
		if (isEmpty())
			return ERROR;
		return stack[topIndex];
	}

	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}

	@Override
	public void popAll() {
		stack = (E[]) new Object[stack.length];
		topIndex = -1;
	}
	
	public boolean isFull() {
		return topIndex == stack.length - 1;
	}
	
	public void print_out() {
		for (int i = 0; i <= topIndex; i++)
			System.out.print(stack[i] + " ");
		System.out.println();
	}
}
