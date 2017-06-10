import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item[] arr;
	private int first;
	private int last;
	
	// construct an empty randomized queue
	public RandomizedQueue(){
		arr = (Item[])new Object[10];
		first = -1;
		last = -1;
	}
	
	// is the queue empty?
	public boolean isEmpty(){
		return (last-first <= 0);
	}
	
	// return the number of items on the queue
	public int size(){
		return last-first;
	}
	
	private void upSize(){
		if(last == arr.length){
			int len = (last-first) * 2;
			resize(len);
		}
	}
	
	private void resize(int len){
		int size = last - first;
		Item[] newArr = (Item[]) new Object[len];
		for(int i=first,j=0 ;i<last; i++,j++){
			if(arr[i] != null){
				newArr[j] = arr[i];
			}
		}
		arr = newArr;
		first = 0;
		last = size;
	}
	
	private void checksBeforeEnqueue(Item item){
		if(item == null){
			throw new NullPointerException("Item being added is null");
		}
	}
	
	// add the item
	public void enqueue(Item item){
		checksBeforeEnqueue(item);
		if(isEmpty()){
			last = 0;
			first = 0;
		}
		upSize();
		arr[last++] = item;
	}
	
	private void resetIfQueueEmpty(){
		if(first >= last){
			first = -1;
			last = -1;
		}
	}
	
	private void downSize(){
		int size = last - first;
		if(size > 0  && size < arr.length/4){
			int len = size * 2;
			resize(len);
		}
	}
	
	private void checkIfQueueEmpty(){
		if(isEmpty()){
			throw new NoSuchElementException("Queue is empty");
		}
	}
	
	// remove and return a random item
	public Item dequeue(){
		checkIfQueueEmpty();
		int index = StdRandom.uniform(first, last);
		Item ret = arr[index];
		if(index != first){
			arr[index] = arr[first];
		}
		first++;
		resetIfQueueEmpty();
		downSize();
		return ret;
	}
	
	// return (but do not remove) a random item
	public Item sample(){
		checkIfQueueEmpty();
		int index = StdRandom.uniform(first, last);
		Item ret = arr[index];
		return ret;
	}

	@Override
	public Iterator<Item> iterator() {
		return new RandomizedQueueArrayIterator();
	}
	
	private class RandomizedQueueArrayIterator implements Iterator<Item> {
		
		RandomizedQueueArrayIterator() {
			super();
			randomizedItems = (Item[])new Object[last - first];
			for(int i=first,j=0; i<last; i++, j++){
				randomizedItems[j] = arr[i];
			}
			StdRandom.shuffle(randomizedItems);
			currentIndex = 0;
		}
		
		private Item[] randomizedItems;
		private int currentIndex;

		@Override
		public boolean hasNext() {
			return (currentIndex < randomizedItems.length);
		}

		@Override
		public Item next() {
			if(currentIndex >= randomizedItems.length){
				throw new NoSuchElementException("No more elements in Queue.");
			}
			return randomizedItems[currentIndex++];
		}
		
	}
	
	/*public static void main(String args[]){
		RandomizedQueue<Integer> r = new RandomizedQueue<>();
		r.enqueue(2);
		System.out.println("Removing "+r.dequeue());
		r.enqueue(1);
		System.out.println(r.dequeue());
	}*/

}
