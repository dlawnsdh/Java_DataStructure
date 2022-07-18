package heap;

public class Heap<E extends Comparable> implements PQInterface<E> {
	private E[] A;
	private int numItems;
	
	public Heap(int n) {
		numItems = 0;
		A = (E[]) new Comparable[n];
	}
	
	public Heap(E[] B, int n) {
		A = B;
		numItems = n;
	}
	
	@Override
	public void insert(E x) throws PQException {
		if (numItems < A.length) {
			A[numItems] = x;
			percolateUp(numItems);
			numItems++;
		}
		else
			throw new PQException("HeapError : Insert-Overflow");
	}
	
	private void percolateUp(int child) {
		int parent = (child - 1) / 2;
		if (parent >= 0 && A[child].compareTo(A[parent]) > 0) {
			E tmp = A[child];
			A[child] = A[parent];
			A[parent] = tmp;
			percolateUp(parent);
		}
	}

	@Override
	public E deleteMax() throws PQException {
		if (!isEmpty()) {
			E max = A[0];
			A[0] = A[numItems - 1];
			numItems--;
			percolateDown(0);
			return max;
		}
		else
			throw new PQException("HeapError : DeleteMax-Underflow");
	}
	
	private void percolateDown(int parent) {
		int child = parent * 2 + 1;
		int rightChild = parent * 2 + 2;
		if (child <= numItems - 1) {
			if (rightChild <= numItems - 1 && A[child].compareTo(A[rightChild]) < 0)
				child = rightChild;
			if (A[parent].compareTo(A[child]) < 0) {
				E tmp = A[child];
				A[child] = A[parent];
				A[parent] = tmp;
				percolateDown(child);
			}
		}
	}

	public void buildHeap() {
		if (numItems >= 2)
			for (int i = (numItems - 2) / 2; i >= 0; i--)
				percolateDown(i);
	}
	
	@Override
	public E max() throws PQException {
		if (isEmpty())
			throw new PQException("HeapError : Max-Empty");
		return A[0];
	}

	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}

	@Override
	public void clear() {
		numItems = 0;
		A = (E[]) new Comparable[A.length];
	}
	
	public void print_out() {
		for (int i = 0; i < numItems; i++)
			System.out.print(A[i] + " ");
		System.out.println();
	}
}
