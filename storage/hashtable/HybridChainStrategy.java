package storage.hashtable;

public class HybridChainStrategy<T> implements IHTChainStrategy<T> {
	@Override
	public IHTRowChain<T> createChain() {
		return new HybridRowChain<T>();
	}
}
