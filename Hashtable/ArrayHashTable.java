package hashTable;

public class ArrayHashTable implements IndexInterface<Integer> {
	private Integer[] table;
	private int numItems;
	static final int DELETE = -12345, NOT_FOUND = -1;
	
	public ArrayHashTable(int n) {
		numItems = 0;
		table = new Integer[n];
		for (int i = 0; i < n; i++)
			table[i] = null;
	}
	
	private int hash(int i, Integer x) {
		return (x + i) % table.length; // 인덱스 값 반환
	}
	
	@Override
	public void insert(Integer x) {
		if (numItems == table.length) {
			Integer[] bigger = new Integer[table.length * 2];
			System.arraycopy(table, 0, bigger, 0, numItems);
			table = bigger;
		}
		int slot;
		for (int i = 0; i < table.length; i++) {
			slot = hash(i, x);
			if (table[slot] == null || table[slot] == DELETE) {
				table[slot] = x;
				numItems++;
				break;
			}
		}
	}

	@Override
	public Integer search(Integer x) {
		int slot;
		for (int i = 0; i < table.length; i++) {
			slot = hash(i, x);
			if (table[slot] == null) 
				return NOT_FOUND;
			if (table[slot].compareTo(x) == 0)
				return slot;
		}
		return NOT_FOUND;
	}

	@Override
	public void delete(Integer x) {
		int slot;
		for (int i = 0; i < table.length; i++) {
			slot = hash(i, x);
			if (table[slot] == null)
				break;
			if (table[slot].compareTo(x) == 0) {
				table[slot] = DELETE;
				numItems--;
				break;
			}
		}
	}

	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < table.length; i++)
			table[i] = null;
		numItems = 0;
	}

	public Integer getItem(int i) {
		return table[i];
	}
	
	public void print_out() {
		for (int i = 0; i < table.length; i++)
			System.out.print(table[i] + " ");
	}
}
