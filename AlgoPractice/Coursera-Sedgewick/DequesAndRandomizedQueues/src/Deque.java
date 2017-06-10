import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node<Item> head;
	private Node<Item> tail;
	private int size;
	
	// construct an empty deque
	public Deque(){
		size = 0;
		head = null;
		tail = null;
	}
	
	// is the deque empty?
	public boolean isEmpty(){
		return (head == null);
	}
	
	// return the number of items on the deque
	public int size(){
		return size;
	}
	
	private void checkItemNull(Item item){
		if(item == null){
			throw new NullPointerException("Item to be added is null.");
		}
	}
	
	// add the item to the front
	public void addFirst(Item item){
		checkItemNull(item);
		Node<Item> node = new Node<Item>(item, head, null);
		if(isEmpty()){
			tail = node;
		}
		else{
			head.setPrevious(node);
		}
		head = node;
		size++;
	}
	
	// add the item to the end
	public void addLast(Item item){
		checkItemNull(item);
		if(isEmpty()){
			addFirst(item);
		}
		else{
			Node<Item> node = new Node<Item>(item, null, tail); 
			tail.setNext(node);
			tail = tail.getNext();
			size++;
		}
	}
	
	private void checkAndSetEmpty(){
		if(head == null){
			tail = null;
		}
		else if(tail == null){
			head = null;
		}
	}
	
	// remove and return the item from the front
	public Item removeFirst(){
		if(isEmpty()){
			throw new NoSuchElementException("No elements in Deque.");
		}
		Item ret = head.getValue();
		head = head.getNext();
		if(head != null){
			head.setPrevious(null);
		}
		checkAndSetEmpty();
		size--;
		return ret;
	}
	
	// remove and return the item from the end
	public Item removeLast(){
		if(isEmpty()){
			throw new NoSuchElementException("No elements in Deque.");
		}
		Item ret = tail.getValue();
		tail = tail.getPrevious();
		if(tail != null){
			tail.setNext(null);
		}
		checkAndSetEmpty();
		size--;
		return ret;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new NodeLinkedListIterator();
	}
	
	private class NodeLinkedListIterator implements Iterator<Item> {

		Node<Item> current = head;
		
		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public Item next() {
			if(!hasNext()){
				throw new NoSuchElementException("No more elements.");
			}
			Item ret = current.getValue();
			current = current.getNext();
			return ret;
		}
		
	}
	
	private class Node<Item> {
		
		public Node(Item value, Node<Item> next, Node<Item> previous){
			this.value = value;
			this.next = next;
			this.previous = previous;
		}
		
		private Item value;
		private Node<Item> next;
		private Node<Item> previous;
		
		public Item getValue() {
			return value;
		}
		public void setValue(Item value) {
			this.value = value;
		}
		public Node<Item> getNext() {
			return next;
		}
		public void setNext(Node<Item> next) {
			this.next = next;
		}
		public Node<Item> getPrevious() {
			return previous;
		}
		public void setPrevious(Node<Item> previous) {
			this.previous = previous;
		}
		
		/*public String toString(){
			String next = "null", prev = "null";
			if(getNext() != null){
				next = getNext().getValue().toString();
			}
			if(getPrevious() != null){
				prev = getPrevious().getValue().toString();
			}
			return "Value: "+value+"; Next: "+next+" ; Prev: "+prev;
		}*/
	}
	
	/*private static void displayHead(Deque d){
		System.out.println("HEAD: "+d.head.toString());
	}
	
	private static void displayTail(Deque d){
		System.out.println("TAIL: "+d.tail.toString());
	}
	
	private static void displayHeadTail(Deque d){
		displayHead(d);
		displayTail(d);
	}
	
	public static void main(String args[]){
	
		Deque<Integer> d = new Deque<>();
		d.addLast(6);
		d.addFirst(7);
		System.out.println(d.size());
		displayHeadTail(d);
		System.out.println("Removing: "+d.removeLast());
		displayHeadTail(d);
		System.out.println(d.size());
		System.out.println("Removing: "+d.removeFirst());
		System.out.println(d.size());
		
	}*/

}
