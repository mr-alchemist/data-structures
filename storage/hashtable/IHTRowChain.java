package storage.hashtable;

public interface IHTRowChain<T> {
	int size();
	boolean add(int key, T value);
	T remove(int key);
	T find(int key);
	
}
