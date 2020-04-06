package storage.hashtable;

public interface IHTChainStrategy<T> {
	IHTRowChain<T> createChain();
}
