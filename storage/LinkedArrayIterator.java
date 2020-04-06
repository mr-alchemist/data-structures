package storage;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedArrayIterator<T> implements Iterator<T> {
	Queue<T> queue = null;
	Node<T> current = null;
	Node<T> prev = null;
	Node<T> prevPrev = null;
	boolean canRemove = false;
	
	public LinkedArrayIterator(LinkedArray<T> la) {
		current = la.queue.getHead();
		prev = null;
		prevPrev = null;
		queue = la.queue;
	}
	
	@Override
	public boolean hasNext() {
		return (current != null);
	}
	
	@Override
	public T next() {
		if(current == null) throw new NoSuchElementException();
		T item = current.getItem();
		if(canRemove)
			prevPrev = prev;
		prev = current;
		current = current.getNext();
		canRemove = true;
		return item;
	}
	
	@Override
	public void remove() {
		if(!canRemove)
			throw new IllegalStateException();
		queue.remove(prev, prevPrev);
		canRemove = false;
	}
}
