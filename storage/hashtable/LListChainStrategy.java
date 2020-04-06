package storage.hashtable;

public class LListChainStrategy<T> implements IHTChainStrategy<T> {
	@Override
	public IHTRowChain<T> createChain() {
		return new LListRowChain<T>();
	}
}
