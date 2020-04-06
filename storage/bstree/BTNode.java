package storage.bstree;

public class BTNode<T> {
	public BTNode<T> left;
	public BTNode<T> right;
	public BTNode<T> parent;
	public int key;
	public T value;
	
	int height;
	
	RBTNodeColor color;
	
	public BTNode() {
		this(null);
	}
	
	public BTNode(BTNode<T> parent) {
		this.parent = parent;
		left = null;
		right = null;
		height = 0;
		color = RBTNodeColor.RED;
		value = null;
	}
	
	@SuppressWarnings("rawtypes")
	static int getHeight(BTNode node) {
		if(node == null)
			return -1;
		return node.height;
	}
	
	public void updateHeight() {
		height = calcHeight();
	}
	
	public int calcHeight() {
		return Math.max(
					getHeight(left), 
					getHeight(right)
				)
				+ 1;
		
	}
	int balance() {
		return getHeight(left) - getHeight(right);
	}
	
	@SuppressWarnings("rawtypes")
	static boolean isBlack(BTNode node) {
		if(node == null || node.color == RBTNodeColor.BLACK) 
			return true;
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	static boolean isRed(BTNode node) {
		return !isBlack(node);
	}
	
	
}

enum RBTNodeColor{
	RED,
	BLACK
}
