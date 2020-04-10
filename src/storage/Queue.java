package storage;

public class Queue<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	public Queue() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public Node<T> getHead(){
		return head;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void enqueue(T item) {
		Node<T> node = new Node<T>(item);
		if(isEmpty()) 
			head = node;
		else 
			tail.setNext(node);
		
		tail = node;
		size++;
	}
	
	public T dequeue() {
		if(isEmpty())
			return null;
		
		T item = head.getItem();
		
		if(head == tail) {
			head = null;
			tail = null;
		}
		else {
			head = head.getNext();
		}
		
		size--;
		return item;
	}
	
	void remove(Node<T> node, Node<T> prevNode) {
		//TODO обработку node=null
		if(head == tail) {
			if(node == head) {
				head = null;
				tail = null;
				if(node != null)size--;//TODO убрать эту проверку, когда будет обработка node=null в начале
				return;
			}
			else {
				throw new UnsupportedOperationException();//TODO change type of exception
			}
		}
		if(node == head) {
			head = head.getNext();
			//с prevNode ничего не делаю, т.к. он null, им и останется
			size--;
			return;
		}
		if(node == tail) {
			tail = prevNode;
			prevNode.setNext(null);
			size--;
			return;
		}
		prevNode.setNext(node.getNext());
		size--;
		return;
	}
	
	void insert(T item, int index) {
		if(index > size() || index < 0)throw new IndexOutOfBoundsException();
		if(index == size()) {
			enqueue(item);
			return;
		}
		Node<T> current = head;
		Node<T> prev = null;
		for(int i = 0; i < index; i++) {
			prev = current;
			current = current.getNext();
		}
		
		Node<T> newNode = new Node<T>(item, current);
		if(current == head) {
			head = newNode;
			return;
		}
		prev.setNext(newNode);
		
	}
	
}
