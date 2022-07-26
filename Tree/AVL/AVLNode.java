package BST;

public class AVLNode {
	private Comparable item;
	private AVLNode left, right;
	private int height;
	
	public AVLNode(Comparable newItem) {
		item = newItem;
		left = right = AVLTree.NIL;
		height = 1;
	}
	
	public AVLNode(Comparable newItem, AVLNode leftChild, AVLNode rightChild) {
		item = newItem;
		left = leftChild;
		right = rightChild;
		height = 1;
	}
	
	public AVLNode(Comparable newItem, AVLNode leftChild, AVLNode rightChild, int h) {
		item = newItem;
		left = leftChild;
		right = rightChild;
		height = h;
	}
	
	public void setItem(Comparable newItem) {
		item = newItem;
	}
	
	public Comparable getItem() {
		return item;
	}
	
	public void setLeft(AVLNode leftChild) {
		left = leftChild;
	}
	
	public AVLNode getLeft() {
		return left;
	}
	
	public void setRight(AVLNode rightChild) {
		right = rightChild;
	}
	
	public AVLNode getRight() {
		return right;
	}
	
	public void setHeight(int h) {
		height = h;
	}
	
	public int getHeight() {
		return height;
	}
}
