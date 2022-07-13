import java.lang.*;
import list.ListInterface;

public class ArrayList<E> implements ListInterface<E> {
	private E[] item;
	private int numItems;
	private static final int DEFAULT_CAPACITY = 64;
	
	public ArrayList() {
		item = (E[]) new Object[DEFAULT_CAPACITY];
		numItems = 0;
	}
	
	public ArrayList(int n) {
		item = (E[]) new Object[n];
		numItems = 0;
	}
	
	@Override
	public void add(int i, E x)  {
		if (numItems >= item.length || i < 0 || i > numItems)
			System.out.println("범위 초과");
		else {
			for (int k = numItems - 1; k >= i; k--) 
				item[k + 1] = item[k];
				item[i] = x;
				numItems++;
		}
	}

	@Override
	public void append(E x) {
		if (numItems < item.length)
			item[numItems++] = x;
		else
			System.out.println("범위 초과");
	}

	@Override
	public E remove(int i) {
		if (isEmpty() || i < 0 || i >= numItems) {
			System.out.println("범위 초과");
			return null;
		}
		else {
			E tmp = item[i];
			for (int k = i; k < numItems - 1; k++) 
				item[k] = item[k + 1];
			numItems--;
			return tmp;
		}
	}

	@Override
	public boolean removeItem(E x) {
		int k = 0;
		while (k < numItems && ((Comparable)item[k]).compareTo(x) != 0)
			k++;
		if (k == numItems)
			return false;
		else {
			for (int i = k; i < numItems - 1; i++) 
				item[i] = item[i + 1];
			numItems--;
			return true;
		}
	}

	@Override
	public E get(int i) {
		if (i >= 0 && i < numItems)
			return item[i];
		else
			return null;
	}

	@Override
	public void set(int i, E x) {
		if (i >= 0 && i < numItems)
			item[i] = x;
		else
			System.out.println("범위 초과");
	}

	private final int NOT_FOUND = -12345;
	@Override
	public int indexOf(E x) {
		for (int i = 0; i < numItems; i++) 
			if (((Comparable)item[i]).compareTo(x) == 0)
				return i;
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
		item = (E[]) new Object[item.length];
		numItems = 0;
	}
	
	public void print_out() {
		for (int i = 0; i < numItems; i++)
			System.out.print(item[i] + " ");
		System.out.println();
	}
}
