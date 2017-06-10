package coursera.algo.sedgewick.queues.generics.linkedlist;

import java.util.Iterator;

import coursera.algo.sedgewick.queues.Queue;

public class QueueOfGenericsUsingLinkedList<T> implements Queue<T>,Iterable<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public QueueOfGenericsUsingLinkedList() {
		super();
		size = 0;
	}

	@Override
	public void enqueue(T t) {
		Node<T> newNode = new Node<T>(t, null);
		if(!isEmpty()){
			tail.setNext(newNode);
		}
		else{
			head = newNode;
		}
		tail = newNode;
		size++;
	}

	@Override
	public T dequeue() {
		Node<T> oldHead = head;
		head = head.getNext();
		if(head == null){
			tail = null;
		}
		size--;
		return oldHead.getValue();
	}

	@Override
	public boolean isEmpty() {
		return(head == null);
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new QueueOfGenericsLinkedListIterator();
	}
	
	private class QueueOfGenericsLinkedListIterator implements Iterator<T>{

		private Node<T> current = head;;
		
		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public T next() {
			T ret = current.getValue();
			current = current.getNext();
			return ret;
		}
		
	}

}
