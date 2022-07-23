package hashTable;
import list.Node;
import list.LinkedList;

public class ChainedHashTable implements IndexInterface<Node>  {
	private LinkedList<Integer>[] table;
	private int numItems;
	
	public ChainedHashTable(int n) {
		table = (LinkedList<Integer>[]) new LinkedList[n];
		for (int i = 0; i < n; i++)
			table[i] = new LinkedList<>();
		numItems = 0;
	}
	
	private int hash(Integer x) {
		return x % table.length; // 인덱스 값 반환
	}
	
	@Override
	public void insert(Integer x) {
		int slot = hash(x);
		table[slot].add(0, x);
		numItems++;
	}

	@Override
	public Node search(Integer x) {
		int slot = hash(x);
		if (table[slot].isEmpty())
			return null;
		int index = table[slot].indexOf(x);
		return table[slot].getNode(index);
	}

	@Override
	public void delete(Integer x) {
		if (isEmpty())
			System.out.println("테이블이 비었음");
		else {
			int slot = hash(x);
			table[slot].removeItem(x);
			numItems--;
		}
	}

	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < table.length; i++)
			table[i] = new LinkedList<>();
		numItems = 0;
	}

	public void print_out() {
		for (int i = 0; i < table.length; i++) {
			Node<Integer> currNode = table[i].getNode(0);
			while (currNode != null) {
				System.out.print(currNode.getItem() + " ");
				currNode = currNode.getNext();
			}
			System.out.println();
		}
	}
}
