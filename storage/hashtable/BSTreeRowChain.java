package storage.hashtable;

import storage.bstree.*;

public class BSTreeRowChain<T> implements IHTRowChain<T> {
	BSTree<T> bsTree;
	int size;
	
	public BSTreeRowChain() {
		bsTree = new AVLTree<T>();
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(int key, T value) {
		BTNode<T> node = bsTree.insert(key, value, true/*uniqueMode*/);
		if(node == null)return false;//значит, в дереве уже есть элемент с таким ключом
		size++;
		return true;
	}

	@Override
	public T remove(int key) {
		BTNode<T> node = bsTree.searchNode(key);
		if(node == null)return null;
		T item = node.value;
		bsTree.remove(node);
		size--;
		return item;
	}

	@Override
	public T find(int key) {
		BTNode<T> node = bsTree.searchNode(key);
		return (node == null)? null : node.value;
	}
	
}
