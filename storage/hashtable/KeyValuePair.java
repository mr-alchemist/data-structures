package storage.hashtable;

public class KeyValuePair<T> {
	int key;
	T value;
	public KeyValuePair(int key, T value) {
		this.key = key;
		this.value = value;
	}
	public KeyValuePair() {
		this(0, null);
	}
}
