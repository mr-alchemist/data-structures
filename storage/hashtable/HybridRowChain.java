package storage.hashtable;

import java.util.Iterator;

public class HybridRowChain<T> implements IHTRowChain<T> {
	IHTRowChain<T> chain;
	public HybridRowChain() {
		chain = new LListRowChain<T>();
	}
	
	@Override
	public int size() {
		return chain.size();
	}

	@Override
	public boolean add(int key, T value) {
		boolean res = chain.add(key, value);
		if(chain.size() == 2 && chain.getClass().getName().equals("LListRowChain")) {
			transformListToTree();
		}
		return res;
	}
	
	private void transformListToTree() {
		BSTreeRowChain<T> treeChain = new BSTreeRowChain<T>();
		Iterator<KeyValuePair<T>> iter = ((LListRowChain<T>)chain).iterator();
		while(iter.hasNext()) {
			KeyValuePair<T> kvp = iter.next();
			treeChain.add(kvp.key, kvp.value);
		}
		chain = treeChain;
	}

	@Override
	public T remove(int key) {
		return chain.remove(key);
	}

	@Override
	public T find(int key) {
		return chain.find(key);
	}
	

}
