package storage.hashtable;

import java.util.Arrays;

public class HashTable<T> {
	
	private static final int DEFAULT_TABLE_SIZE = 8_388_608;//2^23
	
	private int tableSize = 0;
	private Object[] rows = null; 
	private IHTChainStrategy<T> chainStrategy = null;
	
	public HashTable() {
		this(DEFAULT_TABLE_SIZE);
	}
	
	public HashTable(IHTChainStrategy<T> chainStrategy) {
		this(DEFAULT_TABLE_SIZE, chainStrategy);
	}
	
	public HashTable(int tableSize) {
		this(tableSize, new HybridChainStrategy<T>());
	}
	public HashTable(int tableSize, IHTChainStrategy<T> chainStrategy) {
		//TODO проверка аргументов
		this.tableSize = tableSize;
		this.chainStrategy = chainStrategy;
		rows = new Object[this.tableSize];
		Arrays.fill(rows, null);
	}
	
	@SuppressWarnings("unchecked")
	public boolean insert(int key, T value) {
		int index = getIndex(key);
		IHTRowChain<T> tr = (IHTRowChain<T>)rows[index];
		if(tr == null) {
			tr = chainStrategy.createChain();
			rows[index] = tr;
		}
		return tr.add(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public T remove(int key) {
		int index = getIndex(key);
		IHTRowChain<T> tr = (IHTRowChain<T>)rows[index];
		return (tr == null)? null : tr.remove(key);
	}
	
	@SuppressWarnings("unchecked")
	public T find(int key) {
		int index = getIndex(key);
		IHTRowChain<T> tr = (IHTRowChain<T>)rows[index];
		return (tr == null)? null : tr.find(key);
	}
	
	private int getIndex(int key) {
		return Math.abs(key)%tableSize;
	}
	
}
