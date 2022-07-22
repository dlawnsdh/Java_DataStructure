package BST;

public class BinarySearchTree implements IndexInterface<TreeNode> {
	private TreeNode root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	@Override
	public void insert(Comparable newKey) {
		root = insertItem(root, newKey);
	}

	private TreeNode insertItem(TreeNode tNode, Comparable newItem) {
		if (tNode == null)
			tNode = new TreeNode(newItem, null, null);
		else if (tNode.getKey().compareTo(newItem) <= 0)
			tNode.setRight(insertItem(tNode.getRight(), newItem));
		else
			tNode.setLeft(insertItem(tNode.getLeft(), newItem));
		return tNode;
	}
	
	@Override
	public TreeNode search(Comparable searchKey) {
		return searchItem(root, searchKey);
	}

	private TreeNode searchItem(TreeNode tNode, Comparable key) {
		if (tNode == null)
			return null;
		else if (tNode.getKey().compareTo(key) == 0)
			return tNode;
		else if (tNode.getKey().compareTo(key) < 0)
			return searchItem(tNode.getRight(), key);
		else
			return searchItem(tNode.getLeft(), key);
	}
	
	@Override
	public void delete(Comparable searchKey) {
		root = deleteItem(root, searchKey);
	}
	
	private TreeNode deleteItem(TreeNode tNode, Comparable key) {
		if (tNode == null)
			return null;
		else {
			if (tNode.getKey().compareTo(key) == 0)
				tNode = deleteNode(tNode);
			else if (tNode.getKey().compareTo(key) < 0)
				tNode.setRight(deleteItem(tNode.getRight(), key));
			else
				tNode.setLeft(deleteItem(tNode.getLeft(), key));
			return tNode;
		}
	}
	
	private TreeNode deleteNode(TreeNode tNode) {
		if (tNode.getLeft() == null && tNode.getRight() == null) // 리프 노드
			return null;
		else if (tNode.getLeft() == null) // 오른쪽 자식만 있음
			return tNode.getRight();
		else if (tNode.getRight() == null) // 왼쪽 자식만 있음
			return tNode.getLeft();
		else { // 양쪽 자식 모두 있음
			returnPair pair = deleteMinItem(tNode.getRight());
			tNode.setKey(pair.key);
			tNode.setRight(pair.node);
			return tNode;
		}	
	}
	
	private returnPair deleteMinItem(TreeNode tNode) {
		if (tNode.getLeft() == null)
			return new returnPair(tNode.getRight(), tNode.getKey());
		else {
			returnPair pair = deleteMinItem(tNode.getLeft());
			tNode.setLeft(pair.node);
			pair.node = tNode;
			return pair;
		}
	}
	
	private class returnPair {
		private Comparable key;
		private TreeNode node;
		
		public returnPair(TreeNode nd, Comparable it) {
			key = it;
			node = nd;
		}
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void clear() {
		root = null;
	}

	public void preOrder(TreeNode node) {
		if (node != null) {
			System.out.print(node.getKey() + " ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	public TreeNode getRoot() {
		return root;
	}
}
