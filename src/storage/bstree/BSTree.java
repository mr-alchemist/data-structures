package storage.bstree;

public class BSTree<T> {
	BTNode<T> top;
	
	public BSTree() {
		this.top = null;
	}
	
	public BSTree(BTNode<T> top) {
		this.top = top;
	}
	
	public BTNode<T> insert(int x, T value, boolean uniqueMode) {
		if(top == null) {
			top = new BTNode<T>();
			top.key = x;
			top.value = value;
			return top;
		}
		BTNode<T> cur = top;
		
		while(true) {
			if( x > cur.key) {//go to right
				if(cur.right == null) {
					BTNode<T> node = new BTNode<T>(cur);
					node.key = x;
					node.value = value;
					cur.right = node;
					return node;
				}
				cur = cur.right;
			}
			else {//go to left
				if(uniqueMode && cur.key == x)
					return null;
				if(cur.left == null) {
					BTNode<T> node = new BTNode<T>(cur);
					node.key = x;
					node.value = value;
					cur.left = node;
					return node;
				}
				cur = cur.left;
			}
		}
	}
	
	public BTNode<T> insert(int x, T value) {
		return insert(x, value, false);
	}
	
	public void remove(int x) {//удаляет первый найденный узел со значением key
		remove(searchNode(x));
	}
	
	public boolean search(int x) {
		if(searchNode(x) != null)
			return true;
		
		return false;
	}
	
	
	public BTNode<T> searchNode(int key) {
		BTNode<T> cur = top;
		while(cur != null) {
			if(key > cur.key)
				cur = cur.right;
			else {
				if(cur.key == key)
					return cur;
				cur = cur.left;
			}
		}
		return null;
	}
	
	
	BTNode<T> getMinNode(BTNode<T> node) {
		if(node == null)
			return null;
		
		while(true) {
			if(node.left == null)
				return node;
			node = node.left;
		}
	}
	
	BTNode<T> getMaxNode(BTNode<T> node) {
		if(node == null)
			return null;
		
		while(true) {
			if(node.right == null)
				return node;
			node = node.right;
		}
	}
	
	
	public void remove(BTNode<T> node) {
		if(node == null)
			return;
		
		BTNode<T> nodeParent = node.parent;
		
		if( node.left == null || node.right == null ) {//у удаляемого узла node один потомок/поддерево или совсем нет потомков
			//удаляем узел node, "подключаем" его единственного потомка(если он есть) к родителю удаляемого
			BTNode<T> nodeChild = (node.left != null)? node.left: node.right;
			
			if(nodeParent != null) {
				if(nodeParent.left == node )
					nodeParent.left = nodeChild;
				else 
					nodeParent.right = nodeChild;
			}
			if(nodeChild != null)
				nodeChild.parent = nodeParent;
			
			if(top == node) top = nodeChild;
			return;
		}
		//удаление узла, имеющего узлы слева и справа
		//BTNode<T> replacer = getMinNode(node.right);
		BTNode<T> replacer = getMaxNode(node.left);
		
		remove(replacer);
		
		replacer.left = node.left;
		if(node.left != null)
			node.left.parent = replacer;
		
		replacer.right = node.right;
		if(node.right != null)
			node.right.parent = replacer;
		
		replacer.parent = nodeParent;
		if(nodeParent != null) {
			if(nodeParent.left == node )
				nodeParent.left = replacer;
			else 
				nodeParent.right = replacer;
		}
		if(top == node) top = replacer;
	}
	
	//
	public void smallRightRotation() {
		smallRightRotation(top);
	}
	
	public BTNode<T> smallRightRotation(BTNode<T> node) {
		if(node == null)
			return null;
		if(node.left == null)
			return node;
		
		BTNode<T> a = node;
		BTNode<T> b = node.left;
		BTNode<T> c = b.right;
		
		BTNode<T> parent = node.parent;
		
		//top = b;
		b.parent = parent;
		if(parent != null) {
			if(parent.left == node) 
				parent.left = b;
			else 
				parent.right = b;
		}
		
		b.right = a;
		a.parent = b;
		
		a.left = c;
		if(c != null)
			c.parent = a;
		
		if(a == top) top = b;
		
		return b;
	}
	
	public void smallLeftRotation() {
		smallLeftRotation(top);
	}
	
	public BTNode<T> smallLeftRotation(BTNode<T> node) {
		if(node == null)
			return null;
		if(node.right == null)
			return node;
		
		BTNode<T> a = node;
		BTNode<T> b = node.right;
		BTNode<T> c = b.left;
		
		BTNode<T> parent = node.parent;
		
		//top = b;
		b.parent = parent;
		if(parent != null) {
			if(parent.left == node) 
				parent.left = b;
			else 
				parent.right = b;
		}
		
		b.left = a;
		a.parent = b;
		
		a.right = c;
		if(c != null)
			c.parent = a;
		
		if(a == top) top = b;
		
		return b;
	}
	
}
