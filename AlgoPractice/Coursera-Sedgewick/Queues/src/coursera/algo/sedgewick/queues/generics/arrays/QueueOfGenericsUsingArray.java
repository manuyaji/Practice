package coursera.algo.sedgewick.queues.generics.arrays;

import java.util.Iterator;

import coursera.algo.sedgewick.queues.Queue;

public class QueueOfGenericsUsingArray<T> implements Queue<T>,Iterable<T> {

	private T[] arr;
	private int first;
	private int last;
	
	
	
	public QueueOfGenericsUsingArray() {
		super();
		arr = (T[])new Object[10];
		first = -1;
		last = -1;
	}
	
	private void resize(){
		if(last == arr.length){
			int len = last - first;
			int newLen = 0;
			if(len < 5){
				newLen = 10;
			}
			else{
				newLen = len * 2;
			}
			T[] newArr = (T[])new Object[newLen];
			for(int i=0; i<len; i++){
				newArr[i] = arr[first+i];
			}
			arr = newArr;
			first = 0;
			last = len;
		}
	}

	@Override
	public void enqueue(T t) {
		if(first == -1){
			first = 0;
			 last = 0;
		}
		resize();
		arr[last] = t;
		last++;
	}

	@Override
	public T dequeue() {
		if(!isEmpty()){
			T ret = arr[first++];
			if(first >= last){
				first = -1;
				last = -1;
			}
			return ret;
		}
		throw new IllegalStateException("Queue is empty.");
	}

	@Override
	public boolean isEmpty() {
		return (first == -1 && last == -1) || (first >= last);
	}

	@Override
	public int size() {
		return last - first;
	}
	
	
	@Override
	public Iterator<T> iterator() {
		return new QueueOfGenericsArrayIterator();
	}



	private class QueueOfGenericsArrayIterator implements Iterator<T>{
		
		private int index=first;
		
		@Override
		public boolean hasNext() {
			return (index < last-1);
		}

		@Override
		public T next() {
			if(index < last){
				return arr[index++];
			}
			throw new IndexOutOfBoundsException();
		}

		
	}

}
