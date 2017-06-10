package coursera.algo.sedgewick.stacks.strings.linkedlist;

import coursera.algo.sedgewick.stacks.Stack;

public class StackOfStringsUsingLinkedList implements Stack<String>{

	private Node head;
	
	public StackOfStringsUsingLinkedList() {
		super();
		head = null;
	}

	@Override
	public void push(String t) {
		Node oldHead = head;
		head = new Node(t, oldHead);
	}

	@Override
	public String pop() {
		String ret = head.getValue();
		head = head.getNext();
		return ret;
	}

	@Override
	public int size() {
		Node iterator = head;
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

}
