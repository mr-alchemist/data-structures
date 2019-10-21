import storage.*;

public class Program {

	public static void main(String[] args) {
		
		SingleArray<String> singleArray = new SingleArray<String>();
		VectorArray<String> vectorArray = new VectorArray<String>();
		FactorArray<String> factorArray = new FactorArray<String>();
		MatrixArray<String> matrixArray = new MatrixArray<String>(100);
		ArrayListWrap<String> arrListWrap = new ArrayListWrap<String>();
		
		addValues(singleArray, 1000000);
		addValues(vectorArray, 1000000);
		addValues(factorArray, 1000000);
		addValues(matrixArray, 1000000);
		addValues(arrListWrap, 1000000);
		
		/*addValues2(singleArray, 1000000);
		addValues2(vectorArray, 1000000);
		addValues2(factorArray, 1000000);
		addValues2(matrixArray, 1000000);
		addValues2(arrListWrap, 1000000);*/
		
		/*getValues(singleArray, 100000);
		getValues(vectorArray, 100000);
		getValues(factorArray, 100000);
		getValues(matrixArray, 100000);
		getValues(arrListWrap, 100000);
		*/
		
		/*removeValues(singleArray, 1000000);
		removeValues(vectorArray, 1000000);
		removeValues(factorArray, 1000000);
		removeValues(matrixArray, 1000000);
		removeValues(arrListWrap, 1000000);*/
		
		
		/*PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.enqueue(10, "10 first elem");
		pq.enqueue(20, "20 first elem");
		pq.enqueue(20, "20 second elem");
		pq.enqueue(8, "8 elem");
		pq.enqueue(10, "10 second elem");
		
		String s = pq.dequeue();
		while(s != null) {
			System.out.println(s);
			s = pq.dequeue();
		}*/
		
	}
	
	static void addValues(IDynamicArray<String> array, int count) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < count; i++) 
			array.add(i + "");
		
		long duration = System.currentTimeMillis() - start;
		System.out.println("add: " + array + " " + count + " " + duration + " ms");
		
	}
	
	static void getValues(IDynamicArray<String> array, int count) {
		long start = System.currentTimeMillis();
		
		int repeat = 1;
		for(int j = 0; j < repeat; j++)
			for(int i = 0; i < count; i++) 
				array.get(i);
		
		long duration = System.currentTimeMillis() - start;
		System.out.println("get: "+ array + " " + count + " " + duration + " ms");
	}
	
	static void removeValues(IDynamicArray<String> array, int count) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < count; i++) 
			array.remove(0);
		
		long duration = System.currentTimeMillis() - start;
		System.out.println("remove: " + array + " " + count + " " + duration + " ms");
		
	}
	
	static void addValues3(IDynamicArray<String> array, int count) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < count; i++) 
			array.add(i + "",count);
		
		long duration = System.currentTimeMillis() - start;
		System.out.println("add: " + array + " " + count + " " + duration + " ms");
		
	}
	
	static void addValues2(IDynamicArray<String> array, int count) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < count; i++) 
			array.add(i + "", 0);
		
		long duration = System.currentTimeMillis() - start;
		System.out.println("add: " + array + " " + count + " " + duration + " ms");
		
	}
	
	
	
}
