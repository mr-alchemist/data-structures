package storage;

import java.util.Iterator;

public class LinkedArray<T> implements IDynamicArray<T>, Iterable<T> {
	Queue<T> queue;
	
	public LinkedArray() {
		queue = new Queue<T>();
	}
	
	@Override
	public int size() {
		return queue.size();
	}
	
	@Override
	public void add(T item) {
		queue.enqueue(item);
	}
	
	@Override
	public void add(T item, int index) {
		queue.insert(item, index);
	}
	
	@Override
	public T get(int index) {
		if(index >= size() || index < 0)
			return null;
		
		Node<T> curr = queue.getHead();
		for (int i = 0; i < index; i++)
			curr = curr.getNext();
		
		return curr.getItem();
	}
	
	@Override
	public T remove(int index) {
		if(index >= size() || index < 0)throw new IndexOutOfBoundsException();
		Iterator<T> iterator = iterator();
		T current = null;
		for(int j = 0; j < (index + 1); j++)
			current = iterator.next();
		return current;
	}
	
	
	@Override
	public Iterator<T> iterator() {
		return new LinkedArrayIterator<T>(this);
	}
	
	
}
