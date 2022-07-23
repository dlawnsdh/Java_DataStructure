package hashTable;

public interface IndexInterface<T> {
	public void insert(Integer x);
	public T search(Integer x);
	public void delete(Integer x);
	public boolean isEmpty();
	public void clear();
}
