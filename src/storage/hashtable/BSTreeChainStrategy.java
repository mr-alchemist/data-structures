package storage.hashtable;

public class BSTreeChainStrategy<T> implements IHTChainStrategy<T> {
	@Override
	public IHTRowChain<T> createChain() {
		return new BSTreeRowChain<T>();
	}
}
