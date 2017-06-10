package coursera.algo.sedgewick.queues.generics.linkedlist;

public class Node<T> {
	
	public Node(){}
	
	public Node(T value, Node<T> next){
		this.value = value;
		this.next = next;
	}
	
	private T value;
	private Node<T> next;
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}

}
