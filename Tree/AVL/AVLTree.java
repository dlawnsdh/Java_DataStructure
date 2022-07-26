package BST;

public class AVLTree implements IndexInterface<AVLNode> {
	private AVLNode root;
	static final AVLNode NIL = new AVLNode(null, null, null, 0);
	
	public AVLTree() {
		root = NIL;
	}
	
	@Override
	public void insert(Comparable x) {
		root = insertItem(root, x);
	}
	
	private AVLNode insertItem(AVLNode tNode, Comparable item) {
		if (tNode == NIL)
			tNode = new AVLNode(item);
		else if (tNode.getItem().compareTo(item) <= 0) {
			tNode.setRight(insertItem(tNode.getRight(), item));
			tNode.setHeight(1 + Math.max(tNode.getLeft().getHeight(), tNode.getRight().getHeight()));
			int type = needBalance(tNode);
			if (type != NO_NEED)
				tNode = balanceAVL(tNode, type);
		}
		else {
			tNode.setLeft(insertItem(tNode.getLeft(), item));
			tNode.setHeight(1 + Math.max(tNode.getLeft().getHeight(), tNode.getRight().getHeight()));
			int type = needBalance(tNode);
			if (type != NO_NEED)
				tNode = balanceAVL(tNode, type);
		}
		return tNode;
	}

	@Override
	public AVLNode search(Comparable x) {
		return searchItem(root, x);
	}

	private AVLNode searchItem(AVLNode tNode, Comparable item) {
		if (tNode == NIL)
			return NIL;
		else if (tNode.getItem().compareTo(item) == 0)
			return tNode;
		else if (tNode.getItem().compareTo(item) < 0)
			return searchItem(tNode.getRight(), item);
		else
			return searchItem(tNode.getLeft(), item);
	}
	
	@Override
	public void delete(Comparable x) {
		root = deleteItem(root, x);
	}
	
	private AVLNode deleteItem(AVLNode tNode, Comparable item) {
		if (tNode == NIL)
			return NIL;
		else {
			if (tNode.getItem().compareTo(item) == 0) 
				tNode = deleteNode(tNode);
			else if (tNode.getItem().compareTo(item) < 0) {
				tNode.setRight(deleteItem(tNode.getRight(), item));
				tNode.setHeight(1 + Math.max(tNode.getLeft().getHeight(), tNode.getRight().getHeight()));
				int type = needBalance(tNode);
				if (type != NO_NEED)
					tNode = balanceAVL(tNode, type);
			}
			else {
				tNode.setLeft(deleteItem(tNode.getLeft(), item));
				tNode.setHeight(1 + Math.max(tNode.getLeft().getHeight(), tNode.getRight().getHeight()));
				int type = needBalance(tNode);
				if (type != NO_NEED)
					tNode = balanceAVL(tNode, type);
			}
			return tNode;
		}
	}
	
	private AVLNode deleteNode(AVLNode tNode) {
		if (tNode.getLeft() == NIL && tNode.getRight() == NIL) // 리프 노드
			return NIL;
		else if (tNode.getLeft() == NIL)  // 오른쪽 자식만 있음
			return tNode.getRight();
		else if (tNode.getRight() == NIL) // 왼쪽 자식만 있음
			return tNode.getLeft();
		else {                             // 양쪽 자식 모두 있음
			returnPair pair = deleteMinItem(tNode.getRight());
			tNode.setItem(pair.item);
			tNode.setRight(pair.node);
			tNode.setHeight(1 + Math.max(tNode.getLeft().getHeight(), tNode.getRight().getHeight()));
			int type = needBalance(tNode);
			if (type != NO_NEED)
				tNode = balanceAVL(tNode, type);
			return tNode;
		}	
	}
	
	private returnPair deleteMinItem(AVLNode tNode) {
		if (tNode.getLeft() == NIL) 
			return new returnPair(tNode.getRight(), tNode.getItem());
		else {
			returnPair pair = deleteMinItem(tNode.getLeft());
			tNode.setLeft(pair.node);
			tNode.setHeight(1 + Math.max(tNode.getLeft().getHeight(), tNode.getRight().getHeight()));
			int type = needBalance(tNode);
			if (type != NO_NEED)
				tNode = balanceAVL(tNode, type);
			pair.node = tNode;
			return pair;
		}
	}
	
	private class returnPair {
		private Comparable item;
		private AVLNode node;
		
		public returnPair(AVLNode nd, Comparable it) {
			item = it;
			node = nd;
		}
	}

	private AVLNode balanceAVL(AVLNode tNode, int type) {
		AVLNode returnNode = NIL;
		switch (type) {
			case LL: 
				returnNode = rightRotate(tNode);
				break;
			case LR: 
				tNode.setLeft(leftRotate(tNode.getLeft()));
				returnNode  = rightRotate(tNode);
				break;
			case RR: 
				returnNode = leftRotate(tNode);
				break;
			case RL: 
				tNode.setRight(rightRotate(tNode.getRight()));
				returnNode = leftRotate(tNode);
				break;
		}
		return returnNode;
	}
	
	private AVLNode leftRotate(AVLNode t) {
		AVLNode RChild = t.getRight();
		if (RChild == NIL)
			System.out.println(t.getItem() + "의 오른쪽 자식은 NIL이 될 수 없다");
		AVLNode RLChild = RChild.getLeft();
		RChild.setLeft(t);
		t.setRight(RLChild);
		t.setHeight(1 + Math.max(t.getLeft().getHeight(), t.getRight().getHeight()));
		RChild.setHeight(1 + Math.max(RChild.getLeft().getHeight(), RChild.getRight().getHeight()));
		return RChild;
	}
	
	private AVLNode rightRotate(AVLNode t) {
		AVLNode LChild = t.getLeft();
		if (LChild == NIL)
			System.out.println(t.getItem() + "의 왼쪽 자식은 NIL이 될 수 없다");
		AVLNode LRChild = LChild.getRight();
		LChild.setRight(t);
		t.setLeft(LRChild);
		t.setHeight(1 + Math.max(t.getLeft().getHeight(), t.getRight().getHeight()));
		LChild.setHeight(1 + Math.max(LChild.getLeft().getHeight(), LChild.getRight().getHeight()));
		return LChild;
	}
	
	private final int LL = 1, LR = 2, RR = 3, RL = 4, NO_NEED = 0, ILLEGAL = -1;
	private int needBalance(AVLNode t) {
		int type = ILLEGAL;
		if (t.getLeft().getHeight() + 2 <= t.getRight().getHeight()) {                      // R 유형
			if (t.getRight().getLeft().getHeight() <= t.getRight().getRight().getHeight())  // RR 유형
				type = RR;
			else                                                                            // RL 유형
				type = RL;
		}
		else if (t.getLeft().getHeight() >= t.getRight().getHeight() + 2) {                 // L 유형
			if (t.getLeft().getRight().getHeight() <= t.getLeft().getLeft().getHeight())    // LL 유형
				type = LL;
			else                                                                            // LR 유형
				type = LR;
		}
		else 
			type = NO_NEED;
		return type;
	}
	
	@Override
	public boolean isEmpty() {
		return root == NIL;
	}

	@Override
	public void clear() {
		root = NIL;
	}
	
	public void preOrder(AVLNode node) {
		if (node.getItem() != null) {
			System.out.print(node.getItem() + " ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	public AVLNode getRoot() {
		return root;
	}
}
