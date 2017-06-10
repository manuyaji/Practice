package coursera.algo.sedgewick.stacks.generics.linkedlist;

import java.util.Iterator;

import coursera.algo.sedgewick.stacks.Stack;

public class StackOfGenericsUsingLinkedList<T> implements Stack<T>, Iterable<T>{

	private Node<T> head;
	
	public StackOfGenericsUsingLinkedList() {
		super();
		head = null;
	}

	@Override
	public void push(T t) {
		Node<T> oldHead = head;
		head = new Node<T>(t, oldHead);
	}

	@Override
	public T pop() {
		T ret = head.getValue();
		head = head.getNext();
		return ret;
	}

	@Override
	public int size() {
		Node<T> iterator = head;
		int size=0;
		while(iterator != null){
			size++;
			iterator = iterator.getNext();
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (head == null);
	}
	
	@Override
	public Iterator<T> iterator() {
		return new StackOfGenericsLinkedListIterator();
	}

	private class StackOfGenericsLinkedListIterator implements Iterator<T>{

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
