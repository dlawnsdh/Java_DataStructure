package list;

public class BidirectionalNode<E> {
	private E item;
	private BidirectionalNode<E> prev;
	private BidirectionalNode<E> next;
	
	public BidirectionalNode(E newItem) {
		item = newItem;
		prev = null;
		next = null;
	}
	
	public BidirectionalNode(E newItem, BidirectionalNode<E> prevNode, BidirectionalNode<E> nextNode) {
		item = newItem;
		prev = prevNode;
		next = nextNode;
	}
	
	public void setItem(E newItem) {
		item = newItem;
	}
	
	public E getItem() {
		return item;
	}
	
	public void setNext(BidirectionalNode<E> nextNode) {
		next = nextNode;
	}
	
	public BidirectionalNode<E> getNext() {
		return next;
	}
	
	public void setPrev(BidirectionalNode<E> prevNode) {
		prev = prevNode;
	}
	
	public BidirectionalNode<E> getPrev() {
		return prev;
	}
}
