package coursera.algo.sedgewick.queues.strings.linkedlist;

import coursera.algo.sedgewick.queues.Queue;

public class QueueOfStrings implements Queue<String> {
	
	private Node head;
	private Node tail;
	private int size;
	
	public QueueOfStrings() {
		super();
		size = 0;
	}

	@Override
	public void enqueue(String t) {
		Node newNode = new Node(t, null);
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
	public String dequeue() {
		Node oldHead = head;
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

}
