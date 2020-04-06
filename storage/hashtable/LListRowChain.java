package storage.hashtable;

import java.util.Iterator;
import java.util.LinkedList;

//import storage.LinkedArray;

public class LListRowChain<T> implements IHTRowChain<T>, Iterable<KeyValuePair<T>> {
	//LinkedArray<KeyValuePair<T>> list;
	LinkedList<KeyValuePair<T>> list;
	public LListRowChain() {
		//list = new LinkedArray<KeyValuePair<T>>();
		list = new LinkedList<KeyValuePair<T>>();
	}
	@Override
	public int size() {
		return list.size();
	}
	
	private KeyValuePair<T> findPair(int key){
		Iterator<KeyValuePair<T>> iter = list.iterator();
		while(iter.hasNext()) {
			KeyValuePair<T> kvp = iter.next();
			if(kvp.key == key)
				return kvp;
		}
		return null;
	}
	
	@Override
	public T find(int key) {
		KeyValuePair<T> kvp = findPair(key);
		if(kvp == null) return null;
		return kvp.value;
	}
	
	
	private boolean exists(int key) {
		if(findPair(key) != null) return true;
		return false;
	}
	
	@Override
	public boolean add(int key, T value) {
		if(exists(key))//т.е. уже есть значение с таким ключом
			return false;//выходим с признаком false
		
		list.add(new KeyValuePair<T>(key, value));
		return true;
	}
	
	@Override
	public T remove(int key) {
		Iterator<KeyValuePair<T>> iter = list.iterator();
		while(iter.hasNext()) {
			KeyValuePair<T> kvp = iter.next();
			if(kvp.key == key) {
				iter.remove();
				return kvp.value;
			}
		}
		return null;
		
	}
	
	@Override
	public Iterator<KeyValuePair<T>> iterator() {
		return list.iterator();
	}
	
}
