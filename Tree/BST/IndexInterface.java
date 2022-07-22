package BST;

public interface IndexInterface<T> {
	public void insert(Comparable x);
	public T search(Comparable x);
	public void delete(Comparable x);
	public boolean isEmpty();
	public void clear();
}
