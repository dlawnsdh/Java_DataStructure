package BST;

public class TreeNode {
	private Comparable key;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(Comparable newKey) {
		key = newKey;
		left = right = null;
	}
	
	public TreeNode(Comparable newKey, TreeNode leftChild, TreeNode rightChild) {
		key = newKey;
		left = leftChild;
		right = rightChild;
	}
	
	public void setKey(Comparable newKey) {
		key = newKey;
	}
	
	public Comparable getKey() {
		return key;
	}
	
	public void setLeft(TreeNode leftChild) {
		left = leftChild;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public void setRight(TreeNode rightChild) {
		right = rightChild;
	}
	
	public TreeNode getRight() {
		return right;
	}
}
